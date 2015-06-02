package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SnakeLocationAsserter {

	private Snake snake;

	public SnakeLocationAsserter(Snake snake) {
		this.snake = snake;
	}

	public void assertLocation(Joint joint, int value, Axis axis) {
		int theSnakesVerticalCoordinate = snake.getCoordinateOf(joint.ordinal(), axis);
		assertThat(theSnakesVerticalCoordinate, is(value));
	}
}
