package model;

public class GameModel {

	private Snake snake = new Snake().whichIsMoving();

	public SnakeLocation getSnakeLocation() {
		return snake.getLocation();

	}

	public Snake getSnake() {
		return snake;
	}

	public void letSnakeMoveInDirection(Direction direction) {
		snake.setDirectionOfMovement(direction);
	}
}