package model;

import static model.Axis.HORIZONTAL;
import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.Matcher;

public class SnakeLocationAsserter {

	public static void isTenAfterItHasMoved(Direction direction, Snake snake) {
		theSnakesHorizontalCoordinateIsTenAfterItHasMovedIntoDirection(
				direction, snake);
	}

	public static void theSnakesHorizontalCoordinateIsTenAfterItHasMovedIntoDirection(
			Direction direction, Snake snake) {
		snake.move(RIGHT);
		assertThatTheSnakes(HORIZONTAL, is(10), snake);
	}

	static void assertThatTheSnakes(Axis axis, Matcher<Integer> matcher,
			Snake snake) {
		int theSnakesVerticalCoordinate = snake.getCoordinateOf(axis);
		assertThat(theSnakesVerticalCoordinate, matcher);
	}
}
