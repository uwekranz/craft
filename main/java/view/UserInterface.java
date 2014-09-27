package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.Controller;
import controller.DownKeyListener;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_SCREEN_SIZE = Toolkit
			.getDefaultToolkit().getScreenSize();
	private GameView gameView;

	public UserInterface(Controller controller) {
		super();
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameView = new GameView(controller.getGameModel());
		setContentPane(gameView);

		addKeyListener(new DownKeyListener(controller));
	}

	public void displayView() {
		setContentPane(gameView);
		setVisible(true);
		gameView.paintComponent(getGraphics());
		gameView.repaintGameViewRegularly(gameView);
	}

	protected GameView getGameView() {
		return (GameView) getContentPane();
	}

	public void setSnakePainter(SnakePainter snakePainter) {
		gameView.setSnakePainter(snakePainter);
	}

	public Boolean isPaintedRegularly() {
		return gameView.isPaintedRegularly();
	}

}
