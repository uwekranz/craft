package model;

import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.awt.Point;

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
	public void itShouldHaveLengthOne_OnCreation() {
		assertThat(theSnakesInitialLength, is(1));
	}

	@Test
	public void itShouldGetLonger_WhenItEats() {
		snake.eat();
		int theSnakesLengthAfterEating = snake.getLength();

		assertThat(theSnakesInitialLength, is(lessThan(theSnakesLengthAfterEating)));
	}

	@Test
	public void theSnakesInitialLocation_IsTheOrigin() {
		Point theSnakesInitialLocation = snake.getLocation();
		Point theOrigin = new Point(0, 0);

		assertThat(theSnakesInitialLocation, is(theOrigin));
	}

	@Test
	public void itShouldBeMoving_ToTheRight_OnCreation() {
		Direction theSnakesDirectionOfMovement = snake.getDirectionOfMovement();

		assertThat(theSnakesDirectionOfMovement, is(RIGHT));
	}

	@Test
	public void itIsLocated_AtPoint0And1_WhenItHasMovedRightOnce() {
		snake.moveRight();
		Point snakesLocation = snake.getLocation();

		assertThat(snakesLocation, is(new Point(1, 0)));
	}

}
