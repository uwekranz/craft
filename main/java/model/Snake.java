package model;

import java.awt.Point;

public class Snake {

	private int length = 1;

	public void eat() {
		length += 1;
	}

	public int getLength() {
		return length;
	}

	public Point getLocation() {
		return new Point(0, 0);
	}

	public Direction getDirectionOfMovement() {
		return Direction.RIGHT;
	}

}
