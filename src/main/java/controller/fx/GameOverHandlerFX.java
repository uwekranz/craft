package controller.fx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

public class GameOverHandlerFX implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent keyEvent) {
		Platform.runLater(new Runnable() {
			@Override public void run() {
				ButtonType newGameButton = new ButtonType("New Game", ButtonBar.ButtonData.OK_DONE);
				ButtonType quitGameButton = new ButtonType("Quit Game", ButtonBar.ButtonData.CANCEL_CLOSE);

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
						"Game Over!",
						newGameButton,
						quitGameButton);
				alert.setHeaderText(null);
				alert.setGraphic(null);
				alert.setTitle(null);
				alert.initStyle(StageStyle.UNDECORATED);
				alert.showAndWait();

			}
		});
	}
}
