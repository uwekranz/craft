package model;

import static model.Axis.HORIZONTAL_COORDINATE;
import static model.Axis.VERTICAL_COORDINATE;
import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.awt.Point;

import org.hamcrest.Matcher;
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
	public void theSnakesHorizontalCoordinateIsOneAfterItHasMovedRightOnce() {
		snake.moveRight();
		assertThatTheSnakes(HORIZONTAL_COORDINATE, is(1));
	}

	private void assertThatTheSnakes(Axis vertical, Matcher<Integer> matcher) {
		int theSnakesVerticalCoordinate = snake.getCoordinate(vertical);
		assertThat(theSnakesVerticalCoordinate, matcher);
	}

	@Test
	public void theSnakesVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.moveRight();
		assertThatTheSnakes(VERTICAL_COORDINATE, is(0));
	}

	@Test
	public void theSnakesInitialDirectionOfMovementIsRight() {
		Direction theSnakesInitialDirectionOfMovement = snake.getDirectionOfMovement();
		assertThat(theSnakesInitialDirectionOfMovement, is(RIGHT));
	}
}
