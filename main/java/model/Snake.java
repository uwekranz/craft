package model;

import java.awt.Point;

import applicationBoundary.SnakeGameLogger;

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

	public int getCoordinateOf(Axis axis) {
		return location.getCoordinate(axis);
	}

	public void move() {
		move(getDirectionOfMovement());
	}

	public void move(Direction direction) {
		int stepDistance = 10;
		switch (direction) {
		case DOWN:
			location.setCoordinates(
					getLocation().getCoordinate(Axis.HORIZONTAL),
					getLocation().getCoordinate(Axis.VERTICAL) + stepDistance);
			break;
		case LEFT:
			location.setCoordinates(-stepDistance, getLocation()
					.getCoordinate(Axis.VERTICAL));
			break;
		case RIGHT:
			location.setCoordinates(
					getLocation().getCoordinate(Axis.HORIZONTAL)
							+ stepDistance,
					getLocation().getCoordinate(Axis.VERTICAL));
			break;
		case UP:
			location.setCoordinates(
					getLocation().getCoordinate(Axis.HORIZONTAL),
					-stepDistance);
			break;
		}
		move(stepDistance);
		SnakeGameLogger.log("The snakes location is: " + location);
	}

	private MovementStep move(int stepDistance) {
		return new MovementStep(stepDistance);
	}

	public void beginToMove() {
		System.out.println("The snake begins to move");
		Thread thread = new SnakeMovement(this);
		thread.start();
	}

	public void setDirectionOfMovement(Direction direction) {
		this.directionOfMovement = direction;
	}

}
