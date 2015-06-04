package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import applicationBoundary.SnakeGameLogger;

public class SnakeMovement extends Thread {

	private int TICKER_DURATION = 100;
	final int STEP_DISTANCE = 10;
	Direction direction = Direction.RIGHT;

	private Snake snake;
	private Direction formerDirection = direction;

	public SnakeMovement(Snake snake) {
		this.snake = snake;
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
		for (Location bodyPartLocation : location.getBodyPartLocations()) {

			if (movementCausesTurn())
				location.addBodyPartAfterHead();

			switch (direction) {
			case DOWN:
				location.update(bodyPartLocation, STEP_DISTANCE, VERTICAL_AXIS);
				break;
			case LEFT:
				location.update(bodyPartLocation, -STEP_DISTANCE, HORIZONTAL_AXIS);
				break;
			case RIGHT:
				location.update(bodyPartLocation, STEP_DISTANCE, HORIZONTAL_AXIS);
				break;
			case UP:
				location.update(bodyPartLocation, -STEP_DISTANCE, VERTICAL_AXIS);
				break;
			}
		}

		SnakeGameLogger.log("The snakes location is: " + location);
	}

	private boolean movementCausesTurn() {
		return formerDirection != direction;
	}
}
