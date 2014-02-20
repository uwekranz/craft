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
	public void theSnakesFirstCoordinateIsOne_AfterItHasMovedRightOnce() {
		snake.moveRight();
		int snakesFirstLocationCoordinate = snake.getFirstLocationCoordinate();

		assertThat(snakesFirstLocationCoordinate, is(1));
	}

	@Test
	public void theSnakesSecondCoordinateIsZero_AfterItHasMovedRightOnce() {
		snake.moveRight();
		int snakesSecondLocationCoordinate = snake.getSecondLocationCoordinate();

		assertThat(snakesSecondLocationCoordinate, is(0));
	}

}
