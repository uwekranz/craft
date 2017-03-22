package model;

import java.util.Observable;

import applicationBoundary.SnakeGameLogger;

public class Snake extends Observable {

	public static final int INITIAL_BODY_LENGTH = 500;

	SnakeLocation location = new SnakeLocation(INITIAL_BODY_LENGTH);
	private Movement movement;
	private Food foodToDigest;
	private boolean isAlive = true;

	public Snake(Movement movement) {
		this.movement = movement;
	}

	public void eat(Food food) {
		foodToDigest = food;
	}

	public int getBodyLength() {
		return location.getLength();
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

	public boolean isDigesting() {
		return foodToDigest != null && foodToDigest.getSize() != 0;
	}

	public Food getFoodToDigest() {
		return foodToDigest;
	}

	public void setFoodToDigest(Food toDigest) {
		foodToDigest = null;
	}
}
