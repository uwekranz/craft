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
		UserInterface userInterface = new UserInterface();
		SnakeGame.start(userInterface);
		assertThat(userInterface.cageGraphic_HasBeenPainted(), is(true));
	}
}
