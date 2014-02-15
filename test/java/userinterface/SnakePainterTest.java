package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import application.SnakeGame;

public class SnakePainterTest {
	SnakeGame snakeGame;

	@Before
	public void prepareTests() {
		snakeGame = new SnakeGame();
		snakeGame.startWithUserInsterface(new UserInterface());
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
		return snakeGame.getUserInterface().getGameView().snakeHasBeenPainted();
	}

	@Test
	public void itShouldPaintRegularly_WhenGameHasStarted() throws InterruptedException {
		Thread.sleep(1000);

		assertThat(snakeIsPaintedRegularly(snakeGame), is(true));
	}

	private Boolean snakeIsPaintedRegularly(SnakeGame snakeGame) {
		return snakeGame.getUserInterface().getGameView().snakeIsPaintedRegularly();
	}

}
