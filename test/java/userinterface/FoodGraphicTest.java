package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import application.SnakeGame;

public class FoodGraphicTest {
	@Test
	public void itShouldPaintItsSelf_WhenGameHasStarted() {
		SnakeGame snakeGame = new SnakeGame();
		UserInterface userInterface = new UserInterface();
		snakeGame.startWithUserInsterface(userInterface);

		assertThat(userInterface.getGameView().FoodHasBeenPainted(), is(true));
	}
}
