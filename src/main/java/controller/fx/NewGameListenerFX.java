package controller.fx;

import applicationBoundary.ApplicationBoundary;
import applicationBoundary.SnakeGameLogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameListenerFX implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		SnakeGameLogger.info(this, "The New-Game-Button has been pressed.");

		ApplicationBoundary.restart();
	}

}
