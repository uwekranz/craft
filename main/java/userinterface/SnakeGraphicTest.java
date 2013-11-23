package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import application.SnakeGame;

public class SnakeGraphicTest {
	@Test
	public void itShouldPaintItsSelf_WhenGameHasStarted() {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.start();
		SnakeGraphic snakeGraphic = snakeGame.getUserInterface()
				.getCageGraphic().getSnakeGraphic();

		assertThat(snakeGraphic.hasBeenPainted(), is(true));
	}
}
