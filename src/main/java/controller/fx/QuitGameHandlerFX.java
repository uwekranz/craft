package controller.fx;

import applicationBoundary.SnakeGameLogger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.fx.UserInterfaceFX;

public class QuitGameHandlerFX implements EventHandler<ActionEvent> {

	private UserInterfaceFX userInterface;

	public QuitGameHandlerFX(UserInterfaceFX userInterface) {
		this.userInterface = userInterface;
	}

	@Override
	public void handle(ActionEvent keyEvent) {
		SnakeGameLogger.info(this, "The Quit-Game-Button has been pressed.");
	}
}
