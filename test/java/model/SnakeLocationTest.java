package model;

import static model.Coordinate.HORIZONTAL_COORDINATE;
import static model.Coordinate.VERTICAL_COORDINATE;
import static model.Direction.LEFT;
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
	public void theSnakesInitialDirectionOfMovementIsRight() {
		Direction theSnakesInitialDirectionOfMovement = snake.getDirectionOfMovement();
		assertThat(theSnakesInitialDirectionOfMovement, is(RIGHT));
	}

	@Test
	public void theSnakesHorizontalCoordinateIsOneAfterItHasMovedRightOnce() {
		theSnakesHorizontalCoordinateIsOneAfterItHasMoved(RIGHT);
	}

	public void theSnakesHorizontalCoordinateIsOneAfterItHasMoved(Direction direction) {
		snake.move(RIGHT);
		assertThatTheSnakes(HORIZONTAL_COORDINATE, is(1));
	}

	private void assertThatTheSnakes(Coordinate coordinate, Matcher<Integer> matcher) {
		int theSnakesVerticalCoordinate = snake.getCoordinate(coordinate);
		assertThat(theSnakesVerticalCoordinate, matcher);
	}

	@Test
	public void theSnakesVerticalCoordinateIsZeroAfterItHasMovedRightOnce() {
		snake.move(RIGHT);
		assertThatTheSnakes(VERTICAL_COORDINATE, is(0));
	}

	@Test
	public void theSnakesVerticalCoordinateIsOneAfterItHasMovedLeftOnce() {
		theSnakesHorizontalCoordinateIsOneAfterItHasMoved(LEFT);
	}

}
