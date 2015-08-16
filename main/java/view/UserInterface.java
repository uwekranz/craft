package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import applicationBoundary.SnakeGameLogger;
import controller.ArrowKeysListener;
import controller.Controller;

public class UserInterface extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	private GameView gameView;

	public UserInterface(Controller controller) {
		super();
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameView = new GameView(controller.getGameModel());
		setContentPane(gameView);

		addKeyListener(new ArrowKeysListener(controller));
	}

	public void displayView() {
		setContentPane(gameView);
		setVisible(true);
		gameView.paintComponent(getGraphics());
		gameView.repaintGameViewRegularly(gameView);
	}

	@Override
	public void update(Observable observable, Object object) {
		GameOverDialog gameOverDialog = new GameOverDialog();
		gameOverDialog.letUserChoose();
		GameOverOption usersChoice = gameOverDialog.getUsersChoice();
		SnakeGameLogger.info(this, usersChoice.name());
		if (usersChoice.equals(GameOverOption.QUIT_GAME)) {
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}

	public GameView getGameView() {
		return (GameView) getContentPane();
	}

	public void setSnakePainter(SnakePainter snakePainter) {
		gameView.setSnakePainter(snakePainter);
	}

	public Boolean isPaintedRegularly() {
		return gameView.isPaintedRegularly();
	}

}
