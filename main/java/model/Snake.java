package model;

import java.util.Observable;

import applicationBoundary.SnakeGameLogger;

public class Snake extends Observable {

	public static final int INITIAL_BODY_LENGTH = 100;
	private static final int GROWTH_SIZE_CAUSED_BY_EATING = 1;

	private int bodyLength = INITIAL_BODY_LENGTH;
	SnakeLocation location = new SnakeLocation(bodyLength);
	private SnakeMovement movement = new SnakeMovement(this);
	private boolean isAlive;

	public Snake whichIsMoving() {
		beginToMove();
		return this;
	}

	public void eat() {
		bodyLength += GROWTH_SIZE_CAUSED_BY_EATING;
	}

	public void beginToMove() {
		movement.start();
		SnakeGameLogger.info(this, "The snake begins to move");
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
		if (direction.isOppositeOfCurrentDirection(movement)) {
			SnakeGameLogger.info(this, "The snake tried to turn into its opposite Direction directly but it can not.");
			throw new RuntimeException();
		} else {
			movement.setDirection(direction);
		}
	}

	public int getStepDistanceOfMovement() {
		return movement.STEP_DISTANCE;
	}

	public SnakeMovement getMovement() {
		return movement;
	}

	public void die() {
		isAlive = false;
		setChanged();
		notifyObservers(isAlive);
	}

	public boolean isDead() {
		return !isAlive();
	}

	private boolean isAlive() {
		return isAlive;
	}
}
