package model;

public class GameModel {

	private Snake snake = new Snake().whichIsMoving();

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
}