package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import application.SnakeGame;

public class GameViewTest {

	public void itShould_PaintItsSelf_WhenGameHasStarted() {
		UserInterface userInterface = new UserInterface();
		SnakeGame.start(userInterface);

		assertThat(userInterface.cageGraphic_HasBeenPainted(), is(true));
	}
}
