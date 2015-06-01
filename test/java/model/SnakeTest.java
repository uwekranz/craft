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

	// TODO: 01.06.2015, add a test for the initial head location
	@Test
	public void theSnakesInitialTailLocationIsTheOrigin() {

		Location theSnakesInitialTailLocation = snake.getLocation().getTailLocation();
		Location theOrigin = new Location(0, 0);

		assertThat(theSnakesInitialTailLocation, is(theOrigin));
	}

}
