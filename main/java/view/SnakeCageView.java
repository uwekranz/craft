package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import model.GameModel;

public class SnakeCageView extends JComponent {

	private static final long serialVersionUID = 1L;

	private SnakePainter snakePainter;
	private FoodPainter foodPainter;

	private Boolean isPaintedRegularly = false;

	public SnakeCageView(GameModel gameModel, KeyListener arrowKeysListener) {
		snakePainter = new SnakePainter(gameModel);

		foodPainter = new FoodPainter();

		addKeyListener(arrowKeysListener);
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

	public void repaintGameViewRegularly(SnakeCageView gameView) {
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

	public Dimension getDimensions() {
		int width = getWidth();
		int height = getHeight();
		return new Dimension(width, height);
	}

}
