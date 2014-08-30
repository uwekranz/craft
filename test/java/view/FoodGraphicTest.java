package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import controller.Controller;

public class FoodGraphicTest {
	@Test
	public void itShouldGetPainted_WhenTheUserInterfaceIsDisplayed() {
		UserInterface userInterface = new UserInterface(mock(Controller.class));
		userInterface.displayView();
		GameView gameView = userInterface.getGameView();

		assertThat(gameView.hasFoodBeenPainted(), is(true));
	}
}
