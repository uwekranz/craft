package model;

import java.awt.Point;

public class Snake {

	private int length = 1;
	private Location location = new Location(new Point(0, 0));
	private Direction directionOfMovement = Direction.RIGHT;

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

	public Location getLocation() {
		return location;
	}

	public Direction getDirectionOfMovement() {
		return directionOfMovement;
	}

	public int getCoordinate(Coordinate axis) {
		if (axis == Coordinate.HORIZONTAL_COORDINATE)
			return location.getHorizontalCoordinate();
		else
			return location.getVerticalCoordinate();
	}

	public int getSecondLocationCoordinate() {
		return location.getVerticalCoordinate();
	}

	public void move() {
		move(getDirectionOfMovement());
	}

	public void move(Direction direction) {
		int stepDistance = 10;
		switch (direction) {
		case DOWN:
			location.move(getLocation().getHorizontalCoordinate(),
					getLocation().getVerticalCoordinate() + stepDistance);
			break;
		case LEFT:
			location.move(-stepDistance, getLocation().getVerticalCoordinate());
			break;
		case RIGHT:
			location.move(getLocation().getHorizontalCoordinate()
					+ stepDistance, getLocation().getVerticalCoordinate());
			break;
		case UP:
			location.move(getLocation().getHorizontalCoordinate(),
					-stepDistance);
			break;
		}
		move(stepDistance);
		System.out.println("Snake location is: " + location);
	}

	private MovementStep move(int stepDistance) {
		return new MovementStep(stepDistance);
	}

	public void beginToMove() {
		Thread thread = new SnakeMovement(this);
		thread.start();
	}

	public void setDirectionOfMovement(Direction direction) {
		this.directionOfMovement = direction;
	}

}
