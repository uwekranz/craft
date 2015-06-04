package model;

public class GameModel {

	private Snake snake = new Snake().whichIsMoving();

	public SnakeLocation getSnakeLocation() {
		return snake.getLocation();

	}

	public void letSnakeMoveInDirection(Direction direction) {
		SnakeMovement.setDirection(direction);
	}

	public int getSnakeBodyLength() {
		return snake.getBodyLength();
	}
}