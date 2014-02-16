package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import view.GameView;
import view.UserInterface;

public class FoodGraphicTest {
	@Test
	public void itShouldGetPainted_WhenTheUserInterfaceIsDisplayed() {
		UserInterface userInterface = new UserInterface();
		userInterface.displayView();
		GameView gameView = userInterface.getGameView();

		assertThat(gameView.hasFoodBeenPainted(), is(true));
	}
}
