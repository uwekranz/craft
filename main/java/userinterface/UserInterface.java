package userinterface;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = -8899145683554470655L;
	private static final Dimension DEFAULT_SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

	public UserInterface() {
		super();
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void displayGameView() {
		GameView gameView = new GameView();
		setContentPane(gameView);
		setVisible(true);
		gameView.paintComponent(getGraphics());
	}

	protected GameView getGameView() {
		return (GameView) getContentPane();
	}

	protected boolean cageGraphic_HasBeenPainted() {
		return getGameView().cageHasBeenPainted();
	}

}
