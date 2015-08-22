package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameOverDialog {

	private GameOverOption gameOverOption;
	private ActionListener newGameListener;
	private ActionListener quitGameListener;

	public GameOverDialog(ActionListener newGameListener, ActionListener quitGameListener) {
		this.newGameListener = newGameListener;
		this.quitGameListener = quitGameListener;
	}

	public void show() {
		JButton newGameButton = createButton("New Game", newGameListener);
		JButton quitGameButton = createButton("Quit Game", quitGameListener);
		JOptionPane.showOptionDialog(null,//
				"Game Over: The Snake has run into its own body.",//
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

	public GameOverOption getUsersChoice() {
		return gameOverOption;
	}

	public void close() {

	}

}
