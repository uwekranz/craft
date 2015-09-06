package model;

import java.awt.Dimension;

import applicationBoundary.SnakeGameLogger;

public class GameModel {

	private Snake snake;
	private SnakeCage cage;
	private SnakeMovement movement;

	public GameModel() {
		snake = new Snake(movement);
		cage = new SnakeCage();
		movement = new SnakeMovement(snake, cage);

		movement.start();
	}

	public SnakeLocation getSnakeLocation() {
		return snake.getLocation();
	}

	public void letSnakeMoveInDirection(Direction direction) {
		snake.setDirectionOfMovement(direction);
	}

	public int getSnakeBodyLength() {
		return snake.getBodyLength();
	}

	public Snake getSnake() {
		return snake;
	}

	public void setDimensionsOfSnakeCage(Dimension snakeCageViewDimensions) {
		cage.setDimensions(snakeCageViewDimensions);
		SnakeGameLogger.info(this, "Dimensions of snake cage:" + cage.getDimensions());
	}
}