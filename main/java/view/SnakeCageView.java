package view;

import java.awt.Graphics;

import javax.swing.JComponent;

import model.GameModel;
import controller.ArrowKeysListener;
import controller.Controller;

public class SnakeCageView extends JComponent {

	private static final long serialVersionUID = -837919897890926903L;

	private SnakePainter snakePainter;
	private FoodPainter foodPainter;

	private Boolean isPaintedRegularly = false;

	public SnakeCageView(Controller controller) {
		GameModel gameModel = controller.getGameModel();
		snakePainter = new SnakePainter(gameModel);

		foodPainter = new FoodPainter();

		addKeyListeners(controller);
	}

	private void addKeyListeners(Controller controller) {
		ArrowKeysListener arrowKeysListener = new ArrowKeysListener(controller);
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

}
