package userinterface;

import java.awt.Graphics;

import javax.swing.JComponent;

public class GameView extends JComponent {

	private static final long serialVersionUID = -837919897890926903L;

	private SnakePainter snakePainter = new SnakePainter();
	private FoodPainter foodPainter = new FoodPainter();
	private CagePainter cagePainter = new CagePainter();

	public GameView() {
		super();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		paintCage(graphics);
		paintFood(graphics);
		paintSnakeRegularly(graphics);
	}

	private void paintSnakeRegularly(Graphics graphics) {
		snakePainter.paintRegularly(graphics);
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

	protected Boolean FoodHasBeenPainted() {
		return foodPainter.hasFoodBeenPainted();
	}

	protected Boolean snakeHasBeenPainted() {
		return snakePainter.hasPainted();
	}

	public Boolean snakeIsPaintedRegularly() {
		return snakePainter.paintsRegularly();
	}

}
