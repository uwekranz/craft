package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import applicationBoundary.SnakeGameLogger;

public class Snake {

	private int bodyLength = 1;
	private SnakeLocation location = new SnakeLocation();
	private Direction directionOfMovement = Direction.RIGHT;

	public Snake whichIsMoving() {
		beginToMove();
		return this;
	}

	public void eat() {
		bodyLength += 1;
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
