package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class SnakeTest {

	private Snake snake;
	int snakesInitialLength;

	@Before
	public void setUp() {
		snake = new Snake();
		snakesInitialLength = snake.getLength();
	}

	@Test
	public void itShouldHaveLengthOne_OnCreation() {
		assertThat(snakesInitialLength, is(1));
	}

	@Test
	public void itShouldGetLonger_WhenItEats() {
		snake.eat();
		int snakesCurrentLength = snake.getLength();

		assertThat(snakesInitialLength, is(lessThan(snakesCurrentLength)));
	}

	@Test
	public void itShouldBeLocated_AtPoint0And0_OnCreation() {
		Point snakesLocation = snake.getLocation();

		assertThat(snakesLocation, is(new Point(0, 0)));
	}

	@Test
	public void itShouldBeMoving_ToTheRight_OnCreation() {
		Direction snakesDirectionOfMovement = snake.getDirectionOfMovement();

		assertThat(snakesDirectionOfMovement, is(Direction.RIGHT));
	}

}
