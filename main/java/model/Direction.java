package model;

public enum Direction {
	RIGHT, LEFT, UP, DOWN, NULL;

	public boolean isOppositeOfCurrentDirection(SnakeMovement movement) {
		Direction currentDirection = movement.getDirection();
		Direction oppositeOfCurrentDirection = currentDirection.getOppositeDirection();
		if (this.equals(oppositeOfCurrentDirection))
			return true;
		return false;
	}

	public Direction getOppositeDirection() {
		switch (this) {
		case RIGHT:
			return LEFT;
		case LEFT:
			return RIGHT;
		case UP:
			return DOWN;
		case DOWN:
			return UP;
		default:
			return NULL;
		}
	}
}
