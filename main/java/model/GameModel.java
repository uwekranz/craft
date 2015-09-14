package model;

import java.awt.Dimension;

import applicationBoundary.SnakeGameLogger;

public class GameModel {

	private Snake snake;
	private Cage cage;
	private Movement movement;
	private Food food;

	public GameModel() {
		snake = new Snake(movement);
		cage = new Cage();
		food = new Food();

		movement = new Movement(snake, food, cage);

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

	public Food getFood() {
		return food;
	}

	public Location getLocationOfFood() {
		return food.getLocation();
	}

	public int getSizeOfFood() {
		return food.getSize();
	}
}