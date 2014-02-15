package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import application.SnakeGame;

public class SnakePainterTest {
	SnakeGame snakeGame;
	UserInterface userInterface = new UserInterface();

	@Before
	public void prepareTests() {
		snakeGame = new SnakeGame();
		userInterface = new UserInterface();
		snakeGame.startWithUserInsterface(userInterface);
	}

	@Test
	public void itHasNotPaintedYet_WhenItsNewlyCreated() {
		SnakePainter snakePainter = new SnakePainter();
		assertThat(snakePainter.paintsRegularly(), is(false));
	}

	@Test
	public void itShouldHavePainted_WhenGameHasStarted() {
		assertThat(snakeHasBeenPainted(snakeGame), is(true));
	}

	private Boolean snakeHasBeenPainted(SnakeGame snakeGame) {
		return userInterface.getGameView().snakeHasBeenPainted();
	}

	@Test
	public void itShouldPaintRegularly_WhenGameHasStarted() throws InterruptedException {
		Thread.sleep(1000);

		assertThat(snakeIsPaintedRegularly(snakeGame), is(true));
	}

	private Boolean snakeIsPaintedRegularly(SnakeGame snakeGame) {
		return userInterface.getGameView().snakeIsPaintedRegularly();
	}

}
