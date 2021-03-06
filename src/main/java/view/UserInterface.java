package view;

import static java.awt.Color.BLUE;
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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

	private SnakeCageView snakeCageView;
	private GameOverDialog gameOverDialog;

	private Controller controller;

	public UserInterface(Controller controller) {
		super();

		this.controller = controller;

		initializeSnakeCageView(controller);
		setContentPane(snakeCageView);

		gameOverDialog = createGameOverDialog();

		setSizeAccordingToScreen();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initializeSnakeCageView(Controller controller) {
		GameModel gameModel = controller.getGameModel();
		ArrowKeysListener arrowKeysListener = new ArrowKeysListener(controller);
		snakeCageView = new SnakeCageView(gameModel, arrowKeysListener);
	}

	private GameOverDialog createGameOverDialog() {
		QuitGameListener quitGameListener = new QuitGameListener(this);
		NewGameListener newGameListener = new NewGameListener();

		return new GameOverDialog(this, newGameListener, quitGameListener);
	}

	public void displayGameView() {
		setBackground(BLUE);
		setUndecorated(true);
		setAsFullScreenWindow();

		setContentPane(snakeCageView);

		setVisible(true);
		snakeCageView.requestFocusInWindow();

		snakeCageView.paintComponent(getGraphics());
		snakeCageView.repaintGameViewRegularly(snakeCageView);

		Dimension dimensions = snakeCageView.getDimensions();
		controller.setDimensionsOfSnakeCage(dimensions);
	}

	private void setAsFullScreenWindow() {
		GraphicsEnvironment graphicsEnvironment = getLocalGraphicsEnvironment();
		GraphicsDevice screenDevice = graphicsEnvironment.getDefaultScreenDevice();
		screenDevice.setFullScreenWindow(this);
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

	public void setFoodPainter(FoodPainter foodPainter) {
		snakeCageView.setFoodPainter(foodPainter);
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

	public SnakeCageView getSnakeCageView() {
		return snakeCageView;
	}

}
