package model;

import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameOverTest {

	private Snake snake;
	private SnakeMovement movement;
	private Step step;

	@Before
	public void setUp() {
		snake = new Snake(movement);
		SnakeCage snakeCage = CageFactory.createSnakeCage();
		movement = new SnakeMovement(snake, snakeCage);
		step = new Step(movement);
	}

	@Test
	public void snakeDiesWhenItsHeadMeetsItsBody() throws Exception {
		letSnakeRunIntoItself();
		assertTrue(snake.isDead());
	}

	private void letSnakeRunIntoItself() {
		move(RIGHT);
		move(DOWN);
		move(LEFT);
		move(UP);
	}

	private void move(Direction direction) {
		step.step(direction);
	}

}
