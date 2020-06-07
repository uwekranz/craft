package controller.fx;

import applicationBoundary.ApplicationBoundary;
import applicationBoundary.SnakeGameLogger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NewGameHandlerFX implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent actionEvent) {
		SnakeGameLogger.info(this, "The New-Game-Button has been pressed.");

		ApplicationBoundary.restart();
	}
}
