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

	public void moveRight() {
		location.move(1, 0);
	}

	public int getFirstLocationCoordinate() {
		return location.x;
	}

	public int getSecondLocationCoordinate() {
		return location.y;
	}
}
