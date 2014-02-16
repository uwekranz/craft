package application;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import userinterface.UserInterface;

public class SnakeGameTest {
	@Test
	public void itShould_BeVisible_WhenGameStarted() {
		SnakeGame snakeGame = new SnakeGame();
		UserInterface userInterface = new UserInterface();
		snakeGame.startWithUserInsterface(userInterface);

		assertThat(userInterface.isVisible(), is(true));
	}
}
