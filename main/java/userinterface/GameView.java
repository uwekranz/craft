package userinterface;

import java.awt.Graphics;

public class GameView extends TypedJComponent {

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
	}

	private void paintFood(Graphics graphics) {
		FoodPainter.drawFood(graphics);
	}

	private void paintCage(Graphics graphics) {
		CagePainter.paintCage(graphics);
	}

	protected Boolean CageHasBeenPainted() {
		return CagePainter.hasCageBeenPainted();
	}

	protected Boolean FoodHasBeenPainted() {
		return FoodPainter.hasFoodBeenPainted();
	}

	protected Boolean SnakeHasBeenPainted() {
		return SnakePainter.hasSnakeBeenPainted();
	}

}
