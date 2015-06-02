package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;

import org.junit.Test;

public class SnakeLocationTest {

	private Snake snake = new Snake();
	private LocationAsserter locationAsserter = new LocationAsserter(snake);

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsTenAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.move(RIGHT);
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(20), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		snake.move(RIGHT);
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.move(Direction.DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.move(DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsTwentyAfterItHasMovedDownTwice() {
		snake.move(DOWN);
		snake.move(DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.move(DOWN);
		snake.move(DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(20), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsZeroAfterItHasMovedUpOnce() {
		snake.move(Direction.UP);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsMinus10AfterItHasMovedUpOnce() {
		snake.move(UP);
		locationAsserter.assertThatTheSnakeLocation(hasValue(-10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAgainAfterItHasMovedDownAndUpOnce() {
		snake.move(DOWN);
		snake.move(UP);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsMinus10AfterItHasMovedLeftOnce() {
		snake.move(LEFT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(-10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsMinus20AfterItHasMovedLeftTwice() {
		snake.move(LEFT);
		snake.move(LEFT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(-20), onIts(HORIZONTAL_AXIS));
	}

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}
