package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import controller.Controller;
import controller.NewGameListener;
import controller.QuitGameListener;

public class UserInterface extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;

	private SnakeCageView snakeCageView;
	private GameOverDialog gameOverDialog;

	public UserInterface(Controller controller) {
		super();

		snakeCageView = new SnakeCageView(controller);
		setContentPane(snakeCageView);

		gameOverDialog = createGameOverDialog();

		setSizeAccordingToScreen();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private GameOverDialog createGameOverDialog() {
		QuitGameListener quitGameListener = new QuitGameListener(this);
		NewGameListener newGameListener = new NewGameListener(this);

		GameOverDialog gameOverDialog = new GameOverDialog(this, newGameListener, quitGameListener);

		return gameOverDialog;
	}

	public void displayGameView() {
		setContentPane(snakeCageView);
		setVisible(true);
		snakeCageView.requestFocusInWindow();
		snakeCageView.paintComponent(getGraphics());
		snakeCageView.repaintGameViewRegularly(snakeCageView);
	}

	@Override
	public void update(Observable observable, Object object) {
		gameOverDialog.show();
	}

	public SnakeCageView getGameView() {
		return (SnakeCageView) getContentPane();
	}

	public void setSnakePainter(SnakePainter snakePainter) {
		snakeCageView.setSnakePainter(snakePainter);
	}

	public Boolean isPaintedRegularly() {
		return snakeCageView.isPaintedRegularly();
	}

	private void setSizeAccordingToScreen() {
		setSize(getDimensionOfScreen());
	}

	private static Dimension getDimensionOfScreen() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public boolean snakeCageViewHasFocus() {
		return snakeCageView.hasFocus();
	}

}
