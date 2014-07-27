package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import controller.SnakeGame;

public class SnakePainterTest {
	SnakeGame snakeGame;
	UserInterface userInterface = new UserInterface();

	@Before
	public void prepareTests() {
		snakeGame = new SnakeGame();
		userInterface = new UserInterface();
		snakeGame.startWithUserInterface(userInterface);
	}

	@Test
	public void itIsNotPaintedRegularlyYet_WhenItIsNewlyCreated() {
		assertThat(userInterface.isPaintedRegularly(), is(false));
	}

	@Test
	public void itShouldHavePainted_WhenGameHasStarted() {
		assertThat(snakeHasBeenPainted(snakeGame), is(true));
	}

	private Boolean snakeHasBeenPainted(SnakeGame snakeGame2) {
		return userInterface.getGameView().snakeHasBeenPainted();
	}

	@Test
	public void itShouldPaintRegularly_WhenGameHasStarted()
			throws InterruptedException {
		Thread.sleep(1000);
		assertThat(userInterface.isPaintedRegularly(), is(true));
	}

}
