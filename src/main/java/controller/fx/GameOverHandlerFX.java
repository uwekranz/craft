package controller.fx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class GameOverHandlerFX implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent keyEvent) {
		Platform.runLater(new Runnable() {
			@Override public void run() {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
						"Present options 'new game' and 'quit game' to player'",
						ButtonType.YES,
						ButtonType.NO);
				alert.showAndWait();
			}
		});
	}
}
