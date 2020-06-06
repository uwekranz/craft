package view.fx;

import controller.Controller;
import controller.NewGameListener;
import controller.QuitGameListener;
import controller.fx.ArrowKeysHandlerFX;
import controller.fx.NewGameListenerFX;
import controller.fx.QuitGameListenerFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import model.GameModel;
import view.GameOverDialog;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class UserInterfaceFX extends Application {

	private SnakeCageViewFX snakeCageView;
	private Controller controller;
	private GameOverDialogFX gameOverDialog;

	private Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;

		gameOverDialog = createGameOverDialog();

		GameModel gameModel = new GameModel();
		controller = new Controller(gameModel, this);
		snakeCageView = new SnakeCageViewFX(gameModel);
		stage.setFullScreen(true);
		Rectangle2D bounds = Screen.getPrimary().getBounds();
		initializeSnakeCageView(bounds);
		final Canvas canvas = new Canvas(bounds.getWidth(), bounds.getHeight());
		Group group = new Group();
		group.getChildren().add(canvas);
		Scene scene = new Scene(group);

		stage.addEventHandler(ActionEvent.ANY,
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						Platform.runLater(new Runnable() {
							@Override public void run() {
								Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
										"Present options 'new game' and 'quit game' to player'", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
								alert.showAndWait();
							}
						});

					}
				});

		scene.setFill(Color.GREEN);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		ArrowKeysHandlerFX arrowKeysHandler = new ArrowKeysHandlerFX(controller);
		scene.addEventHandler(KeyEvent.ANY, arrowKeysHandler);
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
		snakeCageView.paintComponent(graphicsContext);
		snakeCageView.repaintGameViewRegularly();
	}

	public void showGameOverDialog() {
		Event.fireEvent(stage, new ActionEvent());
	}

	private void initializeSnakeCageView(Rectangle2D bounds) {
		double width = bounds.getWidth();
		double height = bounds.getHeight();
		Dimension dimensions = new Dimension((int) width, (int) height);
		controller.setDimensionsOfSnakeCage(dimensions);
		snakeCageView.setWidth(width);
		snakeCageView.setHeight(height);
	}

	private GameOverDialogFX createGameOverDialog() {
		QuitGameListenerFX quitGameListener = new QuitGameListenerFX(this);
		NewGameListenerFX newGameListener = new NewGameListenerFX();

		return new GameOverDialogFX(this, newGameListener, quitGameListener);
	}

	public Boolean isPaintedRegularly() {
		return snakeCageView.isPaintedRegularly();
	}

	private static Dimension getDimensionOfScreen() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public SnakeCageViewFX getSnakeCageView() {
		return snakeCageView;
	}
}
