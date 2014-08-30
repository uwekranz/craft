package controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import view.UserInterface;

public class SnakeGameTest {
	@Test
	public void itShould_BeVisible_WhenGameStarted() {
		SnakeGame snakeGame = new SnakeGame();
		UserInterface userInterface = new UserInterface(mock(Controller.class));

		snakeGame.startWithUserInterface(userInterface);

		assertThat(userInterface.isVisible(), is(true));
	}
}
