package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

import java.util.List;

import applicationBoundary.SnakeGameLogger;

public class Movement extends Thread {

	private int TICKER_DURATION = 20;
	final static int STEP_DISTANCE = 2;
	Direction direction = Direction.RIGHT;

	private Snake snake;
	private Direction formerDirection = direction;
	private Cage cage;
	private Food food;

	public Movement(Snake snake, Food food, Cage cage) {
		this.snake = snake;
		this.cage = cage;
		this.food = food;

		// TODO Sep 14, 2015 - ano: Get rid of this.
		snake.setMovement(this);
	}

	@Override
	public void run() {
		SnakeGameLogger.info(this, "The snake movement begins");

		SnakeGameLogger.info(this, "Snake cage dimensions:" + cage.getDimensions());
		waitForDimesnionsToBeAvailableInSnakeCage();
		SnakeGameLogger.info(this, "Snake cage dimensions:" + cage.getDimensions());

		while (cage.getDimensions() != null && !snake.isDead()) {
			updateSnakeLocation();
			try {
				Thread.sleep(TICKER_DURATION);
			} catch (InterruptedException exception) {
				throw new RuntimeException(exception);
			}
		}

		SnakeGameLogger.info(this, "The Snakes Movement has stopped and it is dead.");
	}

	public void updateSnakeLocation() {
		SnakeLocation location = snake.getLocation();
		if (movementCausesChangeOfDirection()) {
			location.addJointBeforeHead();
			formerDirection = direction;
		}

		location.updateHeadLocation(this);

		if (location.headHasMetBody(direction) || location.headHasMetSnakeCage(cage)) {
			snake.die();
		}

		if (location.hasHeadMetFood(food)) {
			SnakeGameLogger.info(this, "Snake head has met food.");
			snake.eat(food);
		}

		if (snake.isDigesting()) {
			Food food = snake.getFoodToDigest();
			food.decreaseSize();
			if (!snake.isDigesting()) {
				snake.setFoodToDigest(null);
				food.setSize(20);
				food.renewLocation();
			}
		} else {
			location.updateTailLocation(this);
		}

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

	// TODO Sep 14, 2015 - ano: get rid of this
	private void waitForDimesnionsToBeAvailableInSnakeCage() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
