package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import view.UserInterface;
import applicationBoundary.SnakeGameLogger;

public class QuitGameListener implements ActionListener {

	private UserInterface userInterface;

	public QuitGameListener(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		SnakeGameLogger.info(this, "The Quit-Game-Button has been pressed.");

		JOptionPane.getRootFrame().dispose();
		userInterface.dispatchEvent(new WindowEvent(userInterface, WindowEvent.WINDOW_CLOSING));
	}
}
