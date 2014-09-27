package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import controller.UserInterfaceFactory;

public class FoodGraphicTest {
	@Test
	public void itShouldGetPainted_WhenTheUserInterfaceIsDisplayed() {
		UserInterface userInterface = UserInterfaceFactory
				.createMock();
		userInterface.displayView();
		GameView gameView = userInterface.getGameView();

		assertThat(gameView.hasFoodBeenPainted(), is(true));
	}
}
