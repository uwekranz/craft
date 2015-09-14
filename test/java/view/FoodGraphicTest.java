package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import model.Food;

import org.junit.Test;

import controller.UserInterfaceFactory;

public class FoodGraphicTest {
	@Test
	public void itShouldGetPainted_WhenTheUserInterfaceIsDisplayed() {
		FoodPainter foodPainter = new FoodPainter(new Food());
		UserInterface userInterface = UserInterfaceFactory.createMockWithFoodPainter(foodPainter);
		userInterface.displayGameView();

		assertThat(foodPainter.hasFoodBeenPainted(), is(true));

		userInterface.dispose();
	}
}
