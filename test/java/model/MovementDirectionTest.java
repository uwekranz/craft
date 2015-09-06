package model;

import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class MovementDirectionTest {

	private SnakeMovement snakeMovement;

	@Test
	public void theSnakesInitialDirectionOfMovementIsRight() {
		snakeMovement = new SnakeMovement(new Snake(snakeMovement), new SnakeCage());

		Direction theSnakesInitialDirectionOfMovement = snakeMovement.getDirection();
		assertThat(theSnakesInitialDirectionOfMovement, is(RIGHT));
	}
}
