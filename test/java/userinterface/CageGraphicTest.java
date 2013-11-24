package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import application.SnakeGame;

public class CageGraphicTest {

	private CageGraphic cageGraphic = new CageGraphic();

	@Test
	public void itShould_ContainAFoodGraphicComponet() {
		assertThat(cageGraphic.hasComponentOfType(FoodGraphic.class), is(true));
	}

	@Test
	public void itShould_ContainASnakeGraphicComponet() {
		assertThat(cageGraphic.hasComponentOfType(SnakeGraphic.class), is(true));
	}

	@Test
	public void itShould_PaintItsSelf_WhenGameHasStarted() {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.start();
		CageGraphic cageGraphic = snakeGame.getUserInterface().getCageGraphic();

		assertThat(cageGraphic.hasBeenPainted(), is(true));
	}
}
