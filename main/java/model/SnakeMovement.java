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
	private SnakeCage snakeCage;

	public SnakeMovement(Snake snake, SnakeCage snakeCage) {
		this.snake = snake;
		this.snakeCage = snakeCage;

		snake.setMovement(this);

		STEP_DISTANCE = snake.getBodyLength() / 50;
	}

	@Override
	public void run() {
		SnakeGameLogger.info(this, "The snake movement begins");
		SnakeGameLogger.info(this, "Snake cage dimensions:" + snakeCage.getDimensions());
		try {
			// TODO get rid of sleep
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SnakeGameLogger.info(this, "Snake cage dimensions:" + snakeCage.getDimensions());
		SnakeGameLogger.info(this, "Snake is dead:" + snake.isDead());
		while (snakeCage.getDimensions() != null && !snake.isDead()) {
			update(snake.getLocation());
			try {
				Thread.sleep(TICKER_DURATION);
			} catch (InterruptedException exception) {
				throw new RuntimeException(exception);
			}
		}
		SnakeGameLogger.info(this, "The Snakes Movement has stopped and it is dead.");
	}

	public void update(SnakeLocation location) {
		if (movementCausesChangeOfDirection()) {
			location.addJointBeforeHead();
			formerDirection = direction;
		}

		location.updateHeadLocation(this);
		if (location.headHasMetBody(direction) || location.headHasMetSnakeCage(snakeCage)) {
			snake.die();
		}

		location.updateTailLocation(this);

		if (tailHasArrivedAtNextJoint(location)) {
			location.removeJointAfterTail();
		}

		SnakeGameLogger.debug(this, "The snakes location is: " + location);
	}

	private boolean movementCausesChangeOfDirection() {
		return !formerDirection.equals(direction);
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

	private Axis determineAxisOfMovement(Location bodyPartToMove, Location bodyPartToMoveTo) {
		if (horizontalCoordinatesMatch(bodyPartToMove, bodyPartToMoveTo))
			return VERTICAL_AXIS;
		else
			return HORIZONTAL_AXIS;
	}

	private boolean horizontalCoordinatesMatch(Location bodyPartToMove, Location bodyPartToMoveTo) {
		return bodyPartToMove.getCoordinate(HORIZONTAL_AXIS) == bodyPartToMoveTo.getCoordinate(HORIZONTAL_AXIS);
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction newDirection) {
		formerDirection = direction;
		direction = newDirection;
	}

}
