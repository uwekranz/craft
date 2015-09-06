package model;

import static model.Snake.INITIAL_BODY_LENGTH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;

public class SnakeTest {

	private Snake snake;
	private SnakeMovement movement;
	int theSnakesInitialLength;

	@Before
	public void setUp() {
		snake = new Snake(movement);
		Dimension cageDimensions = new Dimension(3000, 1000);
		SnakeCage snakeCage = new SnakeCage(cageDimensions);
		movement = new SnakeMovement(snake, snakeCage);
		theSnakesInitialLength = snake.getBodyLength();
	}

	@Test
	public void theSnakesInitialLengthIsTen() {
		assertThat(theSnakesInitialLength, is(Snake.INITIAL_BODY_LENGTH));
	}

	@Test
	public void theSnakeBecomesLongerWhenItEats() {
		snake.eat();

		int theSnakesLengthAfterEating = snake.getBodyLength();
		assertThat(theSnakesInitialLength, is(lessThan(theSnakesLengthAfterEating)));
	}

	@Test
	public void theSnakesInitialTailLocationIsTheOrigin() {
		Location theSnakesInitialTailLocation = snake.getLocation().getTailLocation();
		Location theOrigin = new Location(0, 0);

		assertThat(theSnakesInitialTailLocation, is(theOrigin));
	}

	@Test
	public void theSnakesInitialHeadLocationIsRightOfTheOrigin() {
		Location theSnakesInitialHeadLocation = snake.getLocation().getHeadLocation();
		Location rightOfTheOrigin = new Location(0 + INITIAL_BODY_LENGTH, 0);

		assertThat(theSnakesInitialHeadLocation, is(rightOfTheOrigin));
	}

}
