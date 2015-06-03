package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;
import static model.BodyPart.HEAD;
import static model.BodyPart.TAIL;
import static model.Snake.INITIAL_BODY_LENGTH;

import org.junit.Test;

public class SnakeLocationTest {

	private Snake snake = new Snake();
	private SnakeLocationAsserter snakeLocationAsserter = new SnakeLocationAsserter(snake);

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.getLocation().updateAccordingTo(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.getLocation().updateAccordingTo(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsTenAfterItHasMovedRightOnce() {
		snake.getLocation().updateAccordingTo(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIs110AfterItHasMovedRightOnce() {
		snake.getLocation().updateAccordingTo(RIGHT);
		snakeLocationAsserter.assertLocation(HEAD, hasValue(10 + INITIAL_BODY_LENGTH), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.getLocation().updateAccordingTo(RIGHT);
		snake.getLocation().updateAccordingTo(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(20), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		snake.getLocation().updateAccordingTo(RIGHT);
		snake.getLocation().updateAccordingTo(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.getLocation().updateAccordingTo(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.getLocation().updateAccordingTo(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsTwentyAfterItHasMovedDownTwice() {
		snake.getLocation().updateAccordingTo(DOWN);
		snake.getLocation().updateAccordingTo(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.getLocation().updateAccordingTo(DOWN);
		snake.getLocation().updateAccordingTo(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(20), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsZeroAfterItHasMovedUpOnce() {
		snake.getLocation().updateAccordingTo(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsMinus10AfterItHasMovedUpOnce() {
		snake.getLocation().updateAccordingTo(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsVerticalCoordinateIsZeroAgainAfterItHasMovedDownAndUpOnce() {
		snake.getLocation().updateAccordingTo(DOWN);
		snake.getLocation().updateAccordingTo(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsMinus10AfterItHasMovedLeftOnce() {
		snake.getLocation().updateAccordingTo(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeTailsHorizontalCoordinateIsMinus20AfterItHasMovedLeftTwice() {
		snake.getLocation().updateAccordingTo(LEFT);
		snake.getLocation().updateAccordingTo(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-20), onIts(HORIZONTAL_AXIS));
	}

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}
