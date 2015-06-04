package model;

import static model.Direction.RIGHT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class MovementDirectionTest {

	@Test
	public void theSnakesInitialDirectionOfMovementIsRight() {
		Direction theSnakesInitialDirectionOfMovement = SnakeMovement.getDirection();
		assertThat(theSnakesInitialDirectionOfMovement, is(RIGHT));
	}

}
