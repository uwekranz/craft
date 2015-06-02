package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import applicationBoundary.SnakeGameLogger;

public class Snake {

	public static final int INITIAL_BODY_LENGTH = 100;
	private int bodyLength = INITIAL_BODY_LENGTH;
	private SnakeLocation location = new SnakeLocation(bodyLength);
	private Direction directionOfMovement = Direction.RIGHT;

	public Snake whichIsMoving() {
		beginToMove();
		return this;
	}

	public void eat() {
		bodyLength += 1;
	}

	public void move() {
		move(getDirectionOfMovement());
	}

	public void move(Direction direction) {
		int stepDistance = 10;
		switch (direction) {
		case DOWN:
			location.add(stepDistance, VERTICAL_AXIS);
			break;
		case LEFT:
			location.add(-stepDistance, HORIZONTAL_AXIS);
			break;
		case RIGHT:
			location.add(stepDistance, HORIZONTAL_AXIS);
			;
			break;
		case UP:
			location.add(-stepDistance, VERTICAL_AXIS);
			break;
		}
		SnakeGameLogger.log("The snakes location is: " + location);
	}

	public void beginToMove() {
		System.out.println("The snake begins to move");
		Thread thread = new SnakeMovement(this);
		thread.start();
	}

	public void setDirectionOfMovement(Direction direction) {
		this.directionOfMovement = direction;
	}

	public int getBodyLength() {
		return bodyLength;
	}

	public SnakeLocation getLocation() {
		return location;
	}

	public Direction getDirectionOfMovement() {
		return directionOfMovement;
	}

	public int getCoordinateOf(int joint, Axis axis) {
		return location.getCoordinate(axis);
	}
}
