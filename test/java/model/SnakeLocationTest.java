package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.BodyPart.HEAD;
import static model.BodyPart.TAIL;
import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;
import static model.Snake.INITIAL_BODY_LENGTH;

import org.junit.Before;
import org.junit.Test;

public class SnakeLocationTest {

	private Snake snake;
	private SnakeLocation location;
	private SnakeMovement movement;
	private int stepDistance;

	private SnakeLocationAsserter snakeLocationAsserter;

	@Before
	public void setUp() {
		snake = new Snake();
		location = snake.getLocation();
		movement = snake.getMovement();
		stepDistance = movement.STEP_DISTANCE;

		snakeLocationAsserter = new SnakeLocationAsserter(snake);
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	private void move(Direction direction) {
		movement.setDirection(direction);
		movement.applyTo(location);
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsStepDistanceAfterItHasMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsSumOfStepDistanceAndInitialBodyLengthAfterItHasMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(stepDistance + INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsDoubleStepDistanceAfterItHasMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	private void moveTwice(Direction direction) {
		move(direction);
		move(RIGHT);
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsDoubleStepDistanceAfterItHasMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(2 * stepDistance + INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsStillZeroAfterItHasMovedDownOnce() {
		move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsStepDistanceAfterItHasMovedDownOnce() {
		move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsZeroAfterItHasMovedDownOnce() {
		move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsTwentyAfterItHasMovedDownTwice() {
		move(DOWN);
		move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		move(DOWN);
		move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsZeroAfterItHasMovedUpOnce() {
		move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsNegativeStepDistanceAfterItHasMovedUpOnce() {
		move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAgainAfterItHasMovedDownAndUpOnce() {
		move(DOWN);
		move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsNegativeStepDistanceAfterItHasMovedLeftOnce() {
		move(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsNegativeDoubleStepDistanceAfterItHasMovedLeftTwice() {
		move(LEFT);
		move(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}