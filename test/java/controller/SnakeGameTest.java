package controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SnakeGameTest {

	@Test
	public void itShould_BeVisible_WhenGameStarted() throws InterruptedException {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.start();
		assertThat(snakeGame.getUserInterface().isVisible(), is(true));
	}

}
