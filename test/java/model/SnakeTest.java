package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Before;
import org.junit.Test;

public class SnakeTest {

	private Snake snake;
	int theSnakesInitialLength;

	@Before
	public void setUp() {
		snake = new Snake();
		theSnakesInitialLength = snake.getBodyLength();
	}

	@Test
	public void theSnakesInitialLengthIsOne() {
		assertThat(theSnakesInitialLength, is(1));
	}

	@Test
	public void theSnakeBecomesLongerWhenItEats() {
		snake.eat();

		int theSnakesLengthAfterEating = snake.getBodyLength();
		assertThat(theSnakesInitialLength, is(lessThan(theSnakesLengthAfterEating)));
	}

	@Test
	public void theSnakesInitialLocationIsTheOrigin() {

		Location theSnakesInitialLocation = snake.getLocation();
		Location theOrigin = new Location(0, 0);

		assertThat(theSnakesInitialLocation, is(theOrigin));
	}

}
