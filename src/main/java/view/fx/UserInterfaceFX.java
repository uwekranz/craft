package view.fx;

import controller.ArrowKeysListener;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import model.GameModel;

import java.awt.*;

public class UserInterfaceFX extends Application {

	private SnakeCageViewFX snakeCageView;
	private Controller controller;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GameModel gameModel = new GameModel();
		controller = new Controller(gameModel);
		initializeSnakeCageView();
		Group group = new Group();
		final Canvas canvas = new Canvas(250,250);
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
		group.getChildren().add(canvas);
		stage.setScene(new Scene(group, snakeCageView.getWidth(), snakeCageView.getHeight()));
		stage.setFullScreen(true);
		stage.show();
		snakeCageView.paintComponent(graphicsContext);
	}

	private void initializeSnakeCageView() {
		GameModel gameModel = controller.getGameModel();
		snakeCageView = new SnakeCageViewFX(gameModel);
	}

	public void displayGameView() {
		snakeCageView.repaintGameViewRegularly(snakeCageView);

		Dimension dimensions = snakeCageView.getDimensions();
		controller.setDimensionsOfSnakeCage(dimensions);
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
