package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.GameModel;
import controller.ArrowKeysListener;
import controller.Controller;
import controller.NewGameListener;
import controller.QuitGameListener;

public class UserInterface extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_SCREEN_SIZE = getDimensionOfScreen();

	private SnakeCageView snakeCageView;
	private GameOverDialog gameOverDialog;

	public UserInterface(Controller controller) {
		super();
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		GameModel gameModel = controller.getGameModel();
		snakeCageView = new SnakeCageView(gameModel);
		setContentPane(snakeCageView);

		addKeyListener(new ArrowKeysListener(controller));
		gameOverDialog = createGameOverDialog();
	}

	private GameOverDialog createGameOverDialog() {
		QuitGameListener quitGameListener = new QuitGameListener(this);
		NewGameListener newGameListener = new NewGameListener(this);
		return new GameOverDialog(newGameListener, quitGameListener);
	}

	public void displayGameView() {
		setContentPane(snakeCageView);
		setVisible(true);
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

	private static Dimension getDimensionOfScreen() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

}
