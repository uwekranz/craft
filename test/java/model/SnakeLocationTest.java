package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.Direction.DOWN;
import static model.Direction.RIGHT;
import static model.Direction.UP;

import org.junit.Test;

public class SnakeLocationTest {

	private Snake snake = new Snake();
	private LocationAsserter locationAsserter = new LocationAsserter(snake);

	@Test
	public void theSnakesVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsTenAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.move(RIGHT);
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(20), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakesVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		snake.move(RIGHT);
		snake.move(RIGHT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakesVerticalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.move(Direction.DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.move(DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsTwentyAfterItHasMovedDownTwice() {
		snake.move(DOWN);
		snake.move(DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakesVerticalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.move(DOWN);
		snake.move(DOWN);
		locationAsserter.assertThatTheSnakeLocation(hasValue(20), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsZeroAfterItHasMovedUpOnce() {
		snake.move(Direction.UP);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakesVerticalCoordinateIsMinus10AfterItHasMovedUpOnce() {
		snake.move(UP);
		locationAsserter.assertThatTheSnakeLocation(hasValue(-10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakesVerticalCoordinateIsZeroAgainAfterItHasMovedDownAndUpOnce() {
		snake.move(DOWN);
		snake.move(UP);
		locationAsserter.assertThatTheSnakeLocation(hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsMinus10AfterItHasMovedLeftOnce() {
		snake.move(Direction.LEFT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(-10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsMinus20AfterItHasMovedLeftTwice() {
		snake.move(Direction.LEFT);
		snake.move(Direction.LEFT);
		locationAsserter.assertThatTheSnakeLocation(hasValue(-20), onIts(HORIZONTAL_AXIS));
	}

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}
