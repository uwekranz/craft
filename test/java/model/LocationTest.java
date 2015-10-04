package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.BodyPart.HEAD;
import static model.BodyPart.TAIL;
import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;
import static model.Movement.STEP_DISTANCE;
import static model.Snake.INITIAL_BODY_LENGTH;

import org.junit.Before;
import org.junit.Test;

public class LocationTest {

	private Snake snake;
	private Movement movement;
	private Step step;
	private int stepDistance;

	private LocationAsserter snakeLocationAsserter;

	@Before
	public void setUp() {
		snake = new Snake(movement);
		Cage snakeCage = CageFactory.createSnakeCage();
		movement = new Movement(snake, new Food(), snakeCage);
		step = new Step(movement);
		stepDistance = STEP_DISTANCE;
		snakeLocationAsserter = new LocationAsserter(snake);
	}

	@Test
	public void tailsVerticalCoordinateIsZeroAfterSnakeMovedRightOnce() {
		move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
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
	public void tailsHorizontalCoordinateDoesNotChangeWithSnakesFirstStepAfterHavingEaten() {
		int tailsInitialHorizontalCoordinate = 0;

		snake.eat();
		move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(tailsInitialHorizontalCoordinate), onIts(HORIZONTAL_AXIS));
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
	public void headsHorizontalCoordinateIsInitialBodyLengthAfterSnakeMovedDownOnce() {
		move(DOWN);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsDoubleStepDistanceAfterSnakeMovedDownTwice() {
		moveTwice(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void headsHorizontalCoordinateIsStilInitialBodyLengthAfterSnakeMovedDownTwice() {
		moveTwice(DOWN);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsStillZeroAfterSnakeMovedDownTwice() {
		moveTwice(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void headsVerticalCoordinateIsDoubleStepDistanceAfterSnakeMovedDownTwice() {
		moveTwice(DOWN);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(2 * stepDistance), onIts(VERTICAL_AXIS));
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
	public void headsVerticalCoordinateIsNegativeStepDistanceAfterSnakeMovedUpOnce() {
		move(UP);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(-stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsStillZeroAgainAfterSnakeMovedDownRightAndUp() {
		move(DOWN);
		move(RIGHT);
		move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void headsVerticalCoordinateIsZeroAgainAfterSnakeMovedDownAndUpOnce() {
		move(DOWN);
		move(RIGHT);
		move(UP);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsDoubleStepDistanceAfterSnakeMovedDownAndLeft() {
		move(DOWN);
		move(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void headsHorizontalCoordinateIsNegativeInitialBodyLengthMinusStepDistanceAfterSnakeMovedDownAndLeft() {
		move(DOWN);
		move(LEFT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(INITIAL_BODY_LENGTH - stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsHorizontalCoordinateIsInitialBodyLengthAfterSnakeMovedLeftEnoughTimesToPassBodyLength() {
		move(DOWN);
		moveMultipleTimes(LEFT, INITIAL_BODY_LENGTH / stepDistance);

		snakeLocationAsserter.assertLocation(TAIL, hasValue(INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void headsHorizontalCoordinateIsZeroAfterSnakeMovedLeftEnoughTimesToPassBodyLength() {
		move(DOWN);
		moveMultipleTimes(LEFT, INITIAL_BODY_LENGTH / stepDistance);

		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void tailsVerticalCoordinateIsStepDistanceAfterSnakeMovedLeftEnoughTimesToPassBodyLength() {
		move(DOWN);
		moveMultipleTimes(LEFT, INITIAL_BODY_LENGTH / stepDistance);

		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void headsVerticalCoordinateIsStepDistanceAfterSnakeMovedLeftEnoughTimesToPassBodyLength() {
		move(DOWN);
		moveMultipleTimes(LEFT, INITIAL_BODY_LENGTH / stepDistance);

		snakeLocationAsserter.assertLocation(HEAD, hasValue(stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void snakeDiesWhenItMeetsTheCageBoundary() throws Exception {

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

	private void move(Direction direction) {
		step.step(direction);
	}
}