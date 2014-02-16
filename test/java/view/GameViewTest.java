package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import view.UserInterface;
import controller.SnakeGame;

public class GameViewTest {

	@Test
	public void itShould_PaintItsSelf_WhenGameHasStarted() {
		UserInterface userInterface = new UserInterface();
		new SnakeGame().startWithUserInterface(userInterface);

		assertThat(userInterface.cageGraphic_HasBeenPainted(), is(true));
	}
}
