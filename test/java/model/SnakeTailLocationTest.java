package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;
import static model.Joint.TAIL;

import org.junit.Test;

public class SnakeTailLocationTest {

	private Snake snake = new Snake();
	private LocationAsserter snakeLocationAsserter = new LocationAsserter(snake);

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsTenAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.move(RIGHT);
		snake.move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(20), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedRightTwice() {
		snake.move(RIGHT);
		snake.move(RIGHT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.move(Direction.DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsZeroAfterItHasMovedDownOnce() {
		snake.move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsTwentyAfterItHasMovedDownTwice() {
		snake.move(DOWN);
		snake.move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.move(DOWN);
		snake.move(DOWN);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(20), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsZeroAfterItHasMovedUpOnce() {
		snake.move(Direction.UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsMinus10AfterItHasMovedUpOnce() {
		snake.move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-10), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsVerticalCoordinateIsZeroAgainAfterItHasMovedDownAndUpOnce() {
		snake.move(DOWN);
		snake.move(UP);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(0), onIts(VERTICAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsMinus10AfterItHasMovedLeftOnce() {
		snake.move(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-10), onIts(HORIZONTAL_AXIS));
	}

	@Test
	public void theSnakeHeadsHorizontalCoordinateIsMinus20AfterItHasMovedLeftTwice() {
		snake.move(LEFT);
		snake.move(LEFT);
		snakeLocationAsserter.assertLocation(TAIL, hasValue(-20), onIts(HORIZONTAL_AXIS));
	}

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}
