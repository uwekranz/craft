package model;

import static model.Coordinate.HORIZONTAL_COORDINATE;
import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matcher;

public class SnakeLocationAsserter {

	public static void isTenAfterItHasMoved(Direction direction, Snake snake) {
		theSnakesHorizontalCoordinateIsTenAfterItHasMovedIntoDirection(direction, snake);
	}

	public static void theSnakesHorizontalCoordinateIsTenAfterItHasMovedIntoDirection(Direction direction, Snake snake) {
		snake.move(RIGHT);
		assertThatTheSnakes(HORIZONTAL_COORDINATE, is(10), snake);
	}

	static void assertThatTheSnakes(Coordinate coordinate, Matcher<Integer> matcher, Snake snake) {
		int theSnakesVerticalCoordinate = snake.getCoordinate(coordinate);
		assertThat(theSnakesVerticalCoordinate, matcher);
	}
}
