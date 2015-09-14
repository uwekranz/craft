package model;

import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class MovementDirectionTest {

	private Movement snakeMovement;

	@Test
	public void theSnakesInitialDirectionOfMovementIsRight() {
		snakeMovement = new Movement(new Snake(snakeMovement), new Food(), new Cage());

		Direction theSnakesInitialDirectionOfMovement = snakeMovement.getDirection();
		assertThat(theSnakesInitialDirectionOfMovement, is(RIGHT));
	}
}
