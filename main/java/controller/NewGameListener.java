package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UserInterface;
import applicationBoundary.ApplicationBoundary;
import applicationBoundary.SnakeGameLogger;

public class NewGameListener implements ActionListener {

	private UserInterface userInterface;

	public NewGameListener(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		SnakeGameLogger.info(this, "The New-Game-Button has been pressed.");
		startNewGame();
		endOldGameAfterNewGameHasBeenStarted();
	}

	private void startNewGame() {
		ApplicationBoundary.startNewGame();
	}

	private void endOldGameAfterNewGameHasBeenStarted() {
		userInterface.dispose();
	}
}
