package model;

import java.awt.Point;

public class GameModel {

	private Snake snake = new Snake().whichIsMoving();

	public Point getSnakeLocation() {
		return snake.getLocation();

	}

	public Snake getSnake() {
		return snake;
	}
}