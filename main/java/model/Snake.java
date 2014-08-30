package model;

import java.awt.Point;

public class Snake {

	private int length = 1;
	private Point location = new Point(0, 0);

	public Snake whichIsMoving() {
		beginToMove();
		return this;
	}

	public void eat() {
		length += 1;
	}

	public int getLength() {
		return length;
	}

	public Point getLocation() {
		return location;
	}

	public Direction getDirectionOfMovement() {
		return Direction.RIGHT;
	}

	public int getCoordinate(Coordinate axis) {
		if (axis == Coordinate.HORIZONTAL_COORDINATE)
			return location.x;
		else
			return location.y;
	}

	public int getSecondLocationCoordinate() {
		return location.y;
	}

	public void move() {
		move(getDirectionOfMovement());
	}

	public void move(Direction direction) {
		int stepDistance = 10;
		switch (direction) {
		case DOWN:
			location.move(0, stepDistance);
			break;
		case LEFT:
			location.move(-stepDistance, 0);
			break;
		case RIGHT:
			location.move(getLocation().x + stepDistance, getLocation().y);
			break;
		case UP:
			location.move(0, -stepDistance);
			break;
		}
		System.out.println("Snake location is: " + location);
	}

	public void beginToMove() {
		Thread thread = new SnakeMovement(this);
		thread.start();
	}

}
