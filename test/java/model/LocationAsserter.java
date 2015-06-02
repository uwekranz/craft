package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LocationAsserter {

	private Snake snake;

	public LocationAsserter(Snake snake) {
		this.snake = snake;
	}

	public void assertThatTheSnakeHeadsLocation(int value, Axis axis) {
		int theSnakesVerticalCoordinate = snake.getCoordinateOf(axis);
		assertThat(theSnakesVerticalCoordinate, is(value));
	}
}
