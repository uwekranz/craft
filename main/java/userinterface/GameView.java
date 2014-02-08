package userinterface;

import java.awt.Graphics;

public class GameView extends TypedJComponent {

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

	protected Boolean CageHasBeenPainted() {
		return cagePainter.hasCageBeenPainted();
	}

	protected Boolean FoodHasBeenPainted() {
		return foodPainter.hasFoodBeenPainted();
	}

	protected Boolean snakeHasBeenPainted() {
		return snakePainter.hasSnakeBeenPainted();
	}

}
