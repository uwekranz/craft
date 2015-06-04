package model;

import applicationBoundary.SnakeGameLogger;

public class Snake {

	public static final int INITIAL_BODY_LENGTH = 100;
	private static final int GROWTH_SIZE_CAUSED_BY_EATING = 1;

	private int bodyLength = INITIAL_BODY_LENGTH;
	SnakeLocation location = new SnakeLocation(bodyLength);
	private SnakeMovement movement = new SnakeMovement(this);

	public Snake whichIsMoving() {
		beginToMove();
		return this;
	}

	public void eat() {
		bodyLength += GROWTH_SIZE_CAUSED_BY_EATING;
	}

	public void beginToMove() {
		movement.start();
		SnakeGameLogger.log("The snake begins to move");
	}

	public int getBodyLength() {
		return bodyLength;
	}

	public SnakeLocation getLocation() {
		return location;
	}

	public int getCoordinateOf(BodyPart bodyPart, Axis axis) {
		return location.getCoordinate(bodyPart, axis);
	}

	public void setDirectionOfMovement(Direction direction) {
		movement.setDirection(direction);
	}

	public int getStepDistanceOfMovement() {
		return movement.STEP_DISTANCE;
	}
}
