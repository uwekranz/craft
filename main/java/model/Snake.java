package model;

import java.util.Observable;

import applicationBoundary.SnakeGameLogger;

public class Snake extends Observable {

	public static final int INITIAL_BODY_LENGTH = 500;
	private static final int GROWTH_SIZE_CAUSED_BY_EATING = 50;

	private int bodyLength = INITIAL_BODY_LENGTH;
	SnakeLocation location = new SnakeLocation(bodyLength);
	private Movement movement;
	private boolean isAlive = true;

	public Snake(Movement movement) {
		this.movement = movement;
	}

	public void eat() {
		bodyLength += GROWTH_SIZE_CAUSED_BY_EATING;
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

	public Movement getMovement() {
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

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

}
