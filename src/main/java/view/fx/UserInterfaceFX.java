package view.fx;

import controller.Controller;
import controller.fx.ArrowKeysHandlerFX;
import controller.fx.GameOverHandlerFX;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import model.GameModel;

import java.awt.*;

public class UserInterfaceFX extends Application {

	private SnakeCageViewFX snakeCageView;
	private Controller controller;
	private Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		GameModel gameModel = new GameModel();
		controller = new Controller(gameModel, this);
		snakeCageView = new SnakeCageViewFX(gameModel);
		stage.setFullScreen(true);
		Rectangle2D bounds = Screen.getPrimary().getBounds();
		initializeSnakeCageView(bounds);

		final Canvas canvas = new Canvas(bounds.getWidth(), bounds.getHeight());
		Group group = new Group();
		group.getChildren().add(canvas);
		this.scene = new Scene(group);
		scene.setFill(Color.GREEN);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		scene.addEventHandler(KeyEvent.ANY, new ArrowKeysHandlerFX(controller));
		scene.addEventHandler(ActionEvent.ANY, new GameOverHandlerFX());

		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
		snakeCageView.paintComponent(graphicsContext);
		snakeCageView.repaintGameViewRegularly();
	}

	public void fireGameOverEvent() {
		Event.fireEvent(scene, new ActionEvent());
	}

	private void initializeSnakeCageView(Rectangle2D bounds) {
		double width = bounds.getWidth();
		double height = bounds.getHeight();
		Dimension dimensions = new Dimension((int) width, (int) height);
		controller.setDimensionsOfSnakeCage(dimensions);
		snakeCageView.setWidth(width);
		snakeCageView.setHeight(height);
	}
}
