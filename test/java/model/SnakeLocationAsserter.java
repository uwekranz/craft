package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SnakeLocationAsserter {

	private Snake snake;

	public SnakeLocationAsserter(Snake snake) {
		this.snake = snake;
	}

	public void assertLocation(BodyPart bodyPart, int value, Axis axis) {
		int coordinate = snake.getCoordinateOf(bodyPart, axis);
		assertThat(coordinate, is(value));
	}
}
