package model;

import static model.Coordinate.*;
import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.awt.Point;

import org.junit.Test;

public class SnakeLocationTest {

	private Snake snake = new Snake();

	@Test
	public void theSnakesInitialLocationIsTheOrigin() {
		Point theSnakesInitialLocation = snake.getLocation();
		Point theOrigin = new Point(0, 0);
		assertThat(theSnakesInitialLocation, is(theOrigin));
	}

	@Test
	public void theSnakesInitialDirectionOfMovementIsRight() {
		Direction theSnakesInitialDirectionOfMovement = snake.getDirectionOfMovement();
		assertThat(theSnakesInitialDirectionOfMovement, is(RIGHT));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsOneAfterItHasMovedRightOnce() {
		SnakeLocationAsserter.isTenAfterItHasMoved(RIGHT, snake);
	}

	@Test
	public void theSnakesVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		SnakeLocationAsserter.assertThatTheSnakes(VERTICAL_COORDINATE, is(0), snake);
	}
	
	@Test
	public void theSnakesHorizontalCoordinateIsTenAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		SnakeLocationAsserter.assertThatTheSnakes(HORIZONTAL_COORDINATE, is(10), snake);
	}
	
	@Test
	public void theSnakesHorizontalCoordinateIsTwentyAfterItHasMovedRightTwice() {
		snake.move(RIGHT);
		snake.move(RIGHT);
		SnakeLocationAsserter.assertThatTheSnakes(HORIZONTAL_COORDINATE, is(20), snake);
	}

}
