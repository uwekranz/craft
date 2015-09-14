package model;

import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;
import static model.Snake.INITIAL_BODY_LENGTH;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameOverTest {

	private Snake snake;
	private Movement movement;
	private Step step;
	private int tinyCagesWidth;

	@Test
	public void snakeDiesWhenItsRunsIntoItsOwnBody() throws Exception {
		letSnakeRunIntoItself();
		assertTrue(snake.isDead());
	}

	@Test
	public void snakeDiesWhenItRunsIntoRightCageBoundary() throws Exception {
		letSnakeRunIntoCageBoundary(RIGHT);
		assertTrue(snake.isDead());
	}

	@Test
	public void snakeDiesWhenItRunsIntoLeftCageBoundary() throws Exception {
		letSnakeRunIntoCageBoundary(LEFT);
		assertTrue(snake.isDead());
	}

	@Test
	public void snakeDiesWhenItRunsIntoBottomCageBoundary() throws Exception {
		letSnakeRunIntoCageBoundary(DOWN);
		assertTrue(snake.isDead());
	}

	@Test
	public void snakeDiesWhenItRunsIntoTopCageBoundary() throws Exception {
		letSnakeRunIntoCageBoundary(UP);
		assertTrue(snake.isDead());
	}

	private SnakeCage tinyCage() {
		int stepDistance = Movement.STEP_DISTANCE;
		tinyCagesWidth = INITIAL_BODY_LENGTH + stepDistance;
		return CageFactory.createSnakeCage(tinyCagesWidth, stepDistance);
	}

	private void letSnakeRunIntoCageBoundary(Direction direction) {
		setUpMovementIn(tinyCage());
		runIntoCageBoundary(direction);
	}

	private void runIntoCageBoundary(Direction direction) {
		if (direction.equals(LEFT)) {
			move(DOWN);

			moveToLeftBoundary();
		} else {
			move(direction);
			move(direction);
		}
	}

	private void moveToLeftBoundary() {
		for (int i = 1; i <= tinyCagesWidth; i++) {
			move(LEFT);
		}
	}

	private void letSnakeRunIntoItself() {
		setUpMovementIn(snakeCage());

		move(RIGHT);
		move(DOWN);
		move(LEFT);
		move(UP);
	}

	private void move(Direction direction) {
		step.step(direction);
	}

	private void setUpMovementIn(SnakeCage snakeCage) {
		snake = new Snake(movement);
		movement = new Movement(snake, new Food(), snakeCage);
		step = new Step(movement);
	}

	private SnakeCage snakeCage() {
		return CageFactory.createSnakeCage();
	}
}
