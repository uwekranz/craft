package controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import view.UserInterface;

public class SnakeGameTest {

	@Test
	public void itShould_BeVisible_WhenGameStarted() throws InterruptedException {
		SnakeGame snakeGame = new SnakeGame();
		UserInterface userInterface = UserInterfaceFactory.createMock();

		snakeGame.setUserInterface(userInterface);
		snakeGame.start();

		assertThat(userInterface.isVisible(), is(true));

		userInterface.dispose();
	}

}
