package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameOverDialog {

	private ActionListener newGameListener;
	private ActionListener quitGameListener;
	private UserInterface userInterface;

	public GameOverDialog(UserInterface userInterface, ActionListener newGameListener, ActionListener quitGameListener) {
		this.userInterface = userInterface;
		this.newGameListener = newGameListener;
		this.quitGameListener = quitGameListener;
	}

	public void show() {
		JButton newGameButton = createButton("New Game", newGameListener);
		JButton quitGameButton = createButton("Quit Game", quitGameListener);
		JOptionPane.showOptionDialog(userInterface,//
				"Game Over: The Snake has met an obstruction.",//
				"Game Over",//
				JOptionPane.YES_NO_OPTION,//
				JOptionPane.PLAIN_MESSAGE,//
				null,//
				new Object[] { newGameButton, quitGameButton },//
				newGameButton);
	}

	private JButton createButton(String text, ActionListener listener) {
		JButton newGameButton = new JButton(text);
		newGameButton.addActionListener(listener);
		return newGameButton;
	}

	public void close() {
	}

}
