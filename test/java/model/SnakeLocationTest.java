package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class SnakeLocationTest {

	private Snake snake = new Snake();
	private LocationAsserter locationAsserter = new LocationAsserter(snake);

	@Test
	public void theSnakesInitialLocationIsTheOrigin() {

		Location theSnakesInitialLocation = snake.getLocation();
		Location theOrigin = new Location(0, 0);

		assertThat(theSnakesInitialLocation, is(theOrigin));
	}

	@Test
	public void theSnakesInitialDirectionOfMovementIsRight() {

		Direction theSnakesInitialDirectionOfMovement = snake.getDirectionOfMovement();

		assertThat(theSnakesInitialDirectionOfMovement, is(RIGHT));
	}

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

	private Axis onIts(Axis horizontalAxis) {
		return horizontalAxis;
	}

	private int hasValue(int value) {
		return value;
	}

}
