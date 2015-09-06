package model;

import java.awt.Dimension;

import applicationBoundary.SnakeGameLogger;

public class GameModel {

	private Snake snake = new Snake().whichIsMoving();
	private SnakeCage snakeCage = new SnakeCage();

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
		snakeCage.setDimensions(snakeCageViewDimensions);
		SnakeGameLogger.info(this, "Dimensions of snake cage:" + snakeCage.getDimensions());
	}
}