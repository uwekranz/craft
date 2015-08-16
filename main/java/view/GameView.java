package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import model.GameModel;

public class GameView extends JComponent implements Observer {

	private static final long serialVersionUID = -837919897890926903L;

	private SnakePainter snakePainter;
	private FoodPainter foodPainter;

	private Boolean isPaintedRegularly = false;

	public GameView(GameModel gameModel) {
		snakePainter = new SnakePainter(gameModel);
		foodPainter = new FoodPainter();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		paintFood(graphics);
		paintSnake(graphics);
	}

	private void paintSnake(Graphics graphics) {
		snakePainter.paint(graphics);
	}

	private void paintFood(Graphics graphics) {
		foodPainter.paint(graphics);
	}

	protected Boolean hasFoodBeenPainted() {
		return foodPainter.hasFoodBeenPainted();
	}

	protected SnakePainter getSnakePainter() {
		return snakePainter;
	}

	public void repaintGameViewRegularly(GameView gameView) {
		GameViewRepainter gameViewRepainter = new GameViewRepainter(gameView);
		gameViewRepainter.start();
	}

	public Boolean isPaintedRegularly() {
		return isPaintedRegularly;
	}

	public void setIsPaintedRegularly(boolean isPaintedRegularly) {
		this.isPaintedRegularly = isPaintedRegularly;
	}

	protected void setSnakePainter(SnakePainter snakePainter) {
		this.snakePainter = snakePainter;
	}

	public boolean snakeHasBeenPainted() {
		return snakePainter.hasSnakeBeenPainted();
	}

	@Override
	public void update(Observable observable, Object object) {
		showGameOverDialog();
	}

	private void showGameOverDialog() {
		Object[] options = { "Start New Game", "Quit Game" };
		JOptionPane.showOptionDialog(null,//
				"Game Over: The Snake has run into its own body.",//
				"Game Over",//
				JOptionPane.YES_NO_OPTION,//
				JOptionPane.PLAIN_MESSAGE,//
				null,//
				options, options[0]);
	}

}
