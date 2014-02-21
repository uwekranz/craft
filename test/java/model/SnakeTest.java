package model;

import static model.Axis.HORIZONTAL;
import static model.Axis.VERTICAL;
import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.awt.Point;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

public class SnakeTest {

	private Snake snake;
	int theSnakesInitialLength;

	@Before
	public void setUp() {
		snake = new Snake();
		theSnakesInitialLength = snake.getLength();
	}

	@Test
	public void theSnakesInitialLengthIsOne() {
		assertThat(theSnakesInitialLength, is(1));
	}

	@Test
	public void theSnakeBecomesLongerWhenItEats() {
		snake.eat();
		int theSnakesLengthAfterEating = snake.getLength();

		assertThat(theSnakesInitialLength, is(lessThan(theSnakesLengthAfterEating)));
	}

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
	public void theSnakesHorizontalCoordinateIsOne_AfterItHasMovedRightOnce() {
		snake.moveRight();

		assertCoordinate(HORIZONTAL, is(1));
	}

	@Test
	public void theSnakesVerticalCoordinateIsZero_AfterItHasMovedRightOnce() {
		snake.moveRight();

		assertCoordinate(VERTICAL, is(0));
	}

	private void assertCoordinate(Axis vertical, Matcher<Integer> matcher) {
		int snakesVerticalCoordinate = snake.getCoordinate(vertical);

		assertThat(snakesVerticalCoordinate, matcher);
	}

}
