package controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import controller.SnakeGame;
import view.UserInterface;

public class SnakeGameTest {
	@Test
	public void itShould_BeVisible_WhenGameStarted() {
		SnakeGame snakeGame = new SnakeGame();
		UserInterface userInterface = new UserInterface();
		snakeGame.startWithUserInterface(userInterface);

		assertThat(userInterface.isVisible(), is(true));
	}
}
