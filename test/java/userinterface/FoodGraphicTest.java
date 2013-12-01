package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import application.SnakeGame;

public class FoodGraphicTest {
	@Test
	public void itShouldPaintItsSelf_WhenGameHasStarted() {
		SnakeGame.start(new UserInterface());

		assertThat(SnakeGame.getUserInterface().getCageGraphic().FoodGraphicHasBeenPainted(), is(true));
	}
}
