package view;

import java.awt.Graphics;

import javax.swing.JComponent;

public class GameView extends JComponent {

	private static final long serialVersionUID = -837919897890926903L;

	private SnakePainter snakePainter = new SnakePainter();
	private FoodPainter foodPainter = new FoodPainter();
	private CagePainter cagePainter = new CagePainter();

	private Boolean isPaintedRegularly = false;

	public GameView() {
		super();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		paintCage(graphics);
		paintFood(graphics);
		paintSnake(graphics);
	}

	private void paintSnake(Graphics graphics) {
		snakePainter.paint(graphics);
	}

	private void paintFood(Graphics graphics) {
		foodPainter.paint(graphics);
	}

	private void paintCage(Graphics graphics) {
		cagePainter.paint(graphics);
	}

	protected Boolean cageHasBeenPainted() {
		return cagePainter.hasCageBeenPainted();
	}

	protected Boolean hasFoodBeenPainted() {
		return foodPainter.hasFoodBeenPainted();
	}

	protected Boolean snakeHasBeenPainted() {
		return snakePainter.hasPainted();
	}

	public void repaintGameViewRegularly(GameView gameView) {
		GameViewRepaintingEverySecond gameViewRepaintingEverySecond = new GameViewRepaintingEverySecond(
				gameView);
		gameViewRepaintingEverySecond.start();
	}

	public Boolean isPaintedRegularly() {
		return isPaintedRegularly;
	}

	public void setIsPaintedRegularly(boolean isPaintedRegularly) {
		this.isPaintedRegularly = isPaintedRegularly;
	}

}
