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
	public void tailsVerticalCoordinateIsZeroAfterSnakeMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	private void move(Direction direction) {
		movement.setDirection(direction);
		movement.applyTo(location);
	}

	@Test
	public void headsVerticalCoordinateIsZeroAfterSnakeMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsStepDistanceAfterSnakeMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void headsHorizontalCoordinateIsSumOfStepDistanceAndInitialBodyLengthAfterSnakeMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(stepDistance + INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsDoubleStepDistanceAfterSnakeMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void headsHorizontalCoordinateIsDoubleStepDistanceAfterSnakeMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(2 * stepDistance + INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsZeroAfterSnakeMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void headsVerticalCoordinateIsZeroAfterSnakeMovedRightTwice() {
		moveTwice(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsStillZeroAfterSnakeMovedDownOnce() {
		move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void headsVerticalCoordinateIsStepDistanceAfterSnakeMovedDownOnce() {
		move(DOWN);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsStepDistanceAfterSnakeMovedDownOnce() {
		move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsDoubleStepDistanceAfterSnakeMovedDownTwice() {
		moveTwice(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsStillZeroAfterSnakeMovedDownTwice() {
		moveTwice(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsStepDistanceAfterSnakeMovedUpOnce() {
		move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void headsHorizontalCoordinateIsStepDistanceAfterSnakeMovedUpOnce() {
		move(UP);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsStillZeroAfterSnakeMovedUpOnce() {
		move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsZeroAgainAfterSnakeMovedDownAndUpOnce() {
		move(DOWN);
		move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsDoubleStepDistanceAfterSnakeMovedDownAndLeft() {
		move(DOWN);
		move(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsNegativeStepDistanceAfterSnakeMovedLeftEnoughTimesToPassBodyLength() {
		move(DOWN);
		int stepMultiplicity = INITIAL_BODY_LENGTH / stepDistance;
		moveMultipleTimes(LEFT, stepMultiplicity);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-stepDistance), onIts(HORIZONTAL_AXIS));
	}

	private void moveMultipleTimes(Direction direction, int multiplicity) {
		for (int index = 0; index < multiplicity; index++) {
			move(direction);
		}
	}

	private void moveTwice(Direction direction) {
		move(direction);
		move(direction);
	}

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}