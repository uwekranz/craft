package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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
	public void itShould_PaintItsSelf_WhenTheUserInterfaceIsDisplayed() {
		UserInterface userInterface = new UserInterface(cageGraphic);
		userInterface.display();

		assertThat(cageGraphic.hasBeenPainted(), is(true));
	}

}
