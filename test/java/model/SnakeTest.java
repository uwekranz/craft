package model;

import static model.Movement.STEP_DISTANCE;
import static model.Snake.INITIAL_BODY_LENGTH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;

public class SnakeTest {

	private Snake snake;
	private Movement movement;
	int theSnakesInitialLength;

	@Before
	public void setUp() {
		snake = new Snake(movement);
		Dimension cageDimensions = new Dimension(3000, 1000);
		Cage snakeCage = new Cage(cageDimensions);
		movement = new Movement(snake, new Food(), snakeCage);
		theSnakesInitialLength = snake.getBodyLength();
	}

	@Test
	public void theSnakesBodyHasLength() {
		assertThat(theSnakesInitialLength, is(INITIAL_BODY_LENGTH));
	}

	@Test
	public void theSnakeBecomesLongerWhenItEatsAndHasMovesAfterwards() {
		Food food = new Food();
		snake.eat(food);
		int initialSizeOfFood = food.getSize();
		for (int i = 0; i < initialSizeOfFood; i++) {
			moveDown();
		}

		int theSnakesLengthAfterDigesting = snake.getBodyLength();
		assertThat(theSnakesLengthAfterDigesting, is(INITIAL_BODY_LENGTH + initialSizeOfFood * STEP_DISTANCE));
	}

	@Test
	public void theSnakeLengthDoesNotIncreaseWhenDigestianHasFinished() {
		Food food = new Food();
		snake.eat(food);
		int NUMBER_OF_MOVEMENT_STEPS_AFTER_DIGESTION_HAS_FINISHED = 2;
		int initialSizeOfFood = food.getSize();
		for (int i = 0; i < initialSizeOfFood + NUMBER_OF_MOVEMENT_STEPS_AFTER_DIGESTION_HAS_FINISHED; i++) {
			moveDown();
		}

		int theSnakesLengthAfterDigesting = snake.getBodyLength();
		assertThat(theSnakesLengthAfterDigesting, is(theSnakesInitialLength + initialSizeOfFood * STEP_DISTANCE));
	}

	private void moveDown() {
		new Step(movement).step(Direction.DOWN);
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
