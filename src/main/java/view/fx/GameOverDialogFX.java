package view.fx;

import view.UserInterface;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameOverDialogFX {

	private ActionListener newGameListener;
	private ActionListener quitGameListener;
	private UserInterfaceFX userInterface;

	public GameOverDialogFX(UserInterfaceFX userInterface, ActionListener newGameListener, ActionListener quitGameListener) {
		this.userInterface = userInterface;
		this.newGameListener = newGameListener;
		this.quitGameListener = quitGameListener;
	}

	public void show() {
		JButton newGameButton = createButton("New Game", newGameListener);
		JButton quitGameButton = createButton("Quit Game", quitGameListener);
		/*JOptionPane.showOptionDialog(userInterface,//
				"Game Over: The Snake has met an obstruction.",//
				"Game Over",//
				JOptionPane.YES_NO_OPTION,//
				JOptionPane.PLAIN_MESSAGE,//
				null,//
				new Object[] { newGameButton, quitGameButton },//
				newGameButton);*/
	}

	private JButton createButton(String text, ActionListener listener) {
		JButton newGameButton = new JButton(text);
		newGameButton.addActionListener(listener);
		return newGameButton;
	}

	public void close() {
	}

}
