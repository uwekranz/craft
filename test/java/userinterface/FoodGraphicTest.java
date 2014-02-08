package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import application.SnakeGame;

public class FoodGraphicTest {
	@Test
	public void itShouldPaintItsSelf_WhenGameHasStarted() {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.start(new UserInterface());

		assertThat(snakeGame.getUserInterface().getGameView().FoodHasBeenPainted(), is(true));
	}
}
