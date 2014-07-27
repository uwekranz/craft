package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_SCREEN_SIZE = Toolkit
			.getDefaultToolkit().getScreenSize();
	private GameView gameView;

	public UserInterface() {
		super();
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void displayView() {
		gameView = new GameView();
		setContentPane(gameView);
		setVisible(true);
		gameView.paintComponent(getGraphics());
		gameView.repaintGameViewRegularly(gameView);
	}

	protected GameView getGameView() {
		return (GameView) getContentPane();
	}

	protected boolean cageGraphic_HasBeenPainted() {
		return gameView.cageHasBeenPainted();
	}

	public Boolean isPaintedRegularly() {
		return gameView.isPaintedRegularly();
	}

}
