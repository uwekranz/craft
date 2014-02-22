package model;

import static model.Coordinate.HORIZONTAL_COORDINATE;
import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matcher;

public class SnakeLocationAsserter {

	public static void isOneAfterItHasMoved(Direction direction, Snake snake) {
		theSnakesHorizontalCoordinateIsOneAfterItHasMovedIntoDirection(direction, snake);
	}

	public static void theSnakesHorizontalCoordinateIsOneAfterItHasMovedIntoDirection(Direction direction, Snake snake) {
		snake.move(RIGHT);
		assertThatTheSnakes(HORIZONTAL_COORDINATE, is(1), snake);
	}

	static void assertThatTheSnakes(Coordinate coordinate, Matcher<Integer> matcher, Snake snake) {
		int theSnakesVerticalCoordinate = snake.getCoordinate(coordinate);
		assertThat(theSnakesVerticalCoordinate, matcher);
	}
}
