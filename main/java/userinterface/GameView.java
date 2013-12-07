package userinterface;

import java.awt.Graphics;

public class GameView extends TypedJComponent {

	private boolean snakeHasBeenPainted = false;
	private boolean foodHasBeenPainted = false;
	private boolean cageHasBeenPainted = false;

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
		SnakePainter.paintSnake(graphics);
		snakeHasBeenPainted = true;
	}

	private void paintFood(Graphics graphics) {
		FoodPainter.drawFood(graphics);
		foodHasBeenPainted = true;
	}

	private void paintCage(Graphics graphics) {
		CagePainter.paintCage(graphics);
		cageHasBeenPainted = true;
	}

	protected Boolean hasBeenPainted() {
		return cageHasBeenPainted;
	}

	protected Boolean FoodGraphicHasBeenPainted() {
		return foodHasBeenPainted;
	}

	protected Boolean SnakeGraphicHasBeenPainted() {
		return snakeHasBeenPainted;
	}

}
