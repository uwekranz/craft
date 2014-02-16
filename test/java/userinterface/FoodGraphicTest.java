package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FoodGraphicTest {
	@Test
	public void itShouldGetPainted_WhenTheUserInterfaceIsDisplayed() {
		UserInterface userInterface = new UserInterface();
		userInterface.displayView();
		GameView gameView = userInterface.getGameView();

		assertThat(gameView.hasFoodBeenPainted(), is(true));
	}
}
