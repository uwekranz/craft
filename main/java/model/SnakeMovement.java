package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

import java.util.List;

import applicationBoundary.SnakeGameLogger;

public class SnakeMovement extends Thread {

	private int TICKER_DURATION = 40;
	final int STEP_DISTANCE;
	Direction direction = Direction.RIGHT;

	private Snake snake;
	private Direction formerDirection = direction;

	public SnakeMovement(Snake snake) {
		this.snake = snake;
		STEP_DISTANCE = snake.getBodyLength() / 50;
	}

	@Override
	public void run() {
		while (true) {
			applyTo(snake.getLocation());
			try {
				Thread.sleep(TICKER_DURATION);
			} catch (InterruptedException exception) {
				throw new RuntimeException(exception);
			}
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction newDirection) {
		formerDirection = direction;
		direction = newDirection;
	}

	public void applyTo(SnakeLocation location) {
		if (movementCausesChangeOfDirection()) {
			location.addJointBeforeHead();
			formerDirection = direction;
		}

		location.updateHeadLocation(this);
		location.updateTailLocation(this);

		if (tailHasArrivedAtNextJoint(location)) {
			location.removeJointAfterTail();
		}

		SnakeGameLogger.debug(this, "The snakes location is: " + location);
	}

	private boolean tailHasArrivedAtNextJoint(SnakeLocation location) {
		List<Location> bodyParts = location.getBodyParts();
		Location tail = bodyParts.get(0);
		Location tailsNextBodyPart = bodyParts.get(1);
		return tail.equals(tailsNextBodyPart);
	}

	Direction determineDirectionToNextBodyPart(Location bodyPartToMove, Location bodyPartToMoveTo) {
		Axis axisOfMovement = determineAxisOfMovement(bodyPartToMove, bodyPartToMoveTo);
		Direction direction = determineDirectionOfMovement(axisOfMovement, bodyPartToMove, bodyPartToMoveTo);
		return direction;
	}

	private Direction determineDirectionOfMovement(Axis axisOfMovement, Location bodyPartToMove, Location bodyPartToMoveTo) {
		int coordinateOfPartToMoveToOnAxisOfMovement = bodyPartToMoveTo.getCoordinate(axisOfMovement);
		int coordinateOfPartToMoveOnAxisOfMovement = bodyPartToMove.getCoordinate(axisOfMovement);

		if (axisOfMovement == HORIZONTAL_AXIS) {
			if (coordinateOfPartToMoveToOnAxisOfMovement > coordinateOfPartToMoveOnAxisOfMovement)
				return Direction.RIGHT;
			else
				return Direction.LEFT;
		} else {
			if (coordinateOfPartToMoveToOnAxisOfMovement > coordinateOfPartToMoveOnAxisOfMovement)
				return Direction.DOWN;
			else
				return Direction.UP;
		}

	}

	private Axis determineAxisOfMovement(Location bodyPartToMove, Location bodyPartToMoveTo) {
		if (horizontalCoordinatesMatch(bodyPartToMove, bodyPartToMoveTo))
			return VERTICAL_AXIS;
		else
			return HORIZONTAL_AXIS;
	}

	private boolean horizontalCoordinatesMatch(Location bodyPartToMove, Location bodyPartToMoveTo) {
		return bodyPartToMove.getCoordinate(HORIZONTAL_AXIS) == bodyPartToMoveTo.getCoordinate(HORIZONTAL_AXIS);
	}

	private boolean movementCausesChangeOfDirection() {
		return !formerDirection.equals(direction);
	}
}
