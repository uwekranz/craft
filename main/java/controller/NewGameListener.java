package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import applicationBoundary.ApplicationBoundary;
import applicationBoundary.SnakeGameLogger;

public class NewGameListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		SnakeGameLogger.info(this, "The New-Game-Button has been pressed.");
		ApplicationBoundary.restart();
	}

}
