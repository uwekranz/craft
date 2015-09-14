package model;

public enum Direction {
	RIGHT, LEFT, UP, DOWN, NULL;

	public boolean isOppositeOfCurrentDirection(Movement movement) {
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

	public Axis getAxis() {
		switch (this) {
		case RIGHT:
			return Axis.HORIZONTAL_AXIS;
		case LEFT:
			return Axis.HORIZONTAL_AXIS;
		case UP:
			return Axis.VERTICAL_AXIS;
		case DOWN:
			return Axis.VERTICAL_AXIS;
		default:
			return Axis.NULL;
		}
	}

}
