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

import org.junit.Test;

public class SnakeLocationTest {

	private Snake snake = new Snake();
	private SnakeLocationAsserter snakeLocationAsserter = new SnakeLocationAsserter(snake);
	private SnakeLocation snakeLocation = snake.getLocation();
	private int stepDistance = snake.getStepDistanceOfMovement();

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsStepDistanceAfterItHasMovedRightOnce() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsSumOfStepDistanceAndInitialBodyLengthAfterItHasMovedRightOnce() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(stepDistance + INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsDoubleStepDistanceAfterItHasMovedRightTwice() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsDoubleStepDistanceAfterItHasMovedRightTwice() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(2 * stepDistance + INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocation.updateAccordingToMovement(RIGHT, stepDistance);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsStillZeroAfterItHasMovedDownOnce() {
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsStepDistanceAfterItHasMovedDownOnce() {
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsTwentyAfterItHasMovedDownTwice() {
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(2 * stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsZeroAfterItHasMovedUpOnce() {
		snakeLocation.updateAccordingToMovement(UP, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsNegativeStepDistanceAfterItHasMovedUpOnce() {
		snakeLocation.updateAccordingToMovement(UP, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-stepDistance), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAgainAfterItHasMovedDownAndUpOnce() {
		snakeLocation.updateAccordingToMovement(DOWN, stepDistance);
		snakeLocation.updateAccordingToMovement(UP, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsNegativeStepDistanceAfterItHasMovedLeftOnce() {
		snakeLocation.updateAccordingToMovement(LEFT, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-stepDistance), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsNegativeDoubleStepDistanceAfterItHasMovedLeftTwice() {
		snakeLocation.updateAccordingToMovement(LEFT, stepDistance);
		snakeLocation.updateAccordingToMovement(LEFT, stepDistance);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-2 * stepDistance), onIts(HORIZONTAL_AXIS));
	}

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}