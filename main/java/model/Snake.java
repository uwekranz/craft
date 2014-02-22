package model;

import java.awt.Point;

public class Snake {

	private int length = 1;
	private Point location = new Point(0, 0);

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

	public void move(Direction right) {
		location.move(1, 0);
	}
}
