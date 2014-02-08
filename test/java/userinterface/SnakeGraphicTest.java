package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import application.SnakeGame;

public class SnakeGraphicTest {
	@Test
	public void itShouldHaveBeenPainted_WhenGameHasStarted() {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.start(new UserInterface());

		assertThat(snakeHasBeenPainted(snakeGame), is(true));
	}

	private Boolean snakeHasBeenPainted(SnakeGame snakeGame) {
		return snakeGame.getUserInterface().getGameView().snakeHasBeenPainted();
	}

	// TODO replace fake implementation for this test by the real thing
	@Test
	public void itShouldPaintRegularly_WhenGameHasStarted() throws InterruptedException {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.start(new UserInterface());

		Thread.sleep(1000);

		assertThat(snakeIsPaintedRegularly(snakeGame), is(true));
	}

	private Boolean snakeIsPaintedRegularly(SnakeGame snakeGame) {
		return snakeGame.getUserInterface().getGameView().snakeIsPaintedRegularly();
	}

}
