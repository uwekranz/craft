package controller.fx;

import applicationBoundary.SnakeGameLogger;
import view.UserInterface;
import view.fx.UserInterfaceFX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class QuitGameListenerFX implements ActionListener {

	private UserInterfaceFX userInterface;

	public QuitGameListenerFX(UserInterfaceFX userInterface) {
		this.userInterface = userInterface;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		SnakeGameLogger.info(this, "The Quit-Game-Button has been pressed.");

		JOptionPane.getRootFrame().dispose();
		//userInterface.dispatchEvent(new WindowEvent(userInterface, WindowEvent.WINDOW_CLOSING));
	}
}
