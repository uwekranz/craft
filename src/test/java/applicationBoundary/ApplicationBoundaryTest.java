package applicationBoundary;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javafx.stage.Stage;
import org.junit.Test;

import view.UserInterface;
import controller.SnakeGame;

public class ApplicationBoundaryTest {

	ApplicationBoundary applicationBoundary = new ApplicationBoundary();

	@Test
	public void itShould_NotCrash_WhenRunningItsMainMethod() {
		ApplicationBoundary.main(null);
	}

	@Test
	public void itShould_DisplayTheUserInterface_WhenStarted() {
		UserInterface userInterface = mock(UserInterface.class);
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.setUserInterface(userInterface);

		snakeGame.start();

		verify(userInterface).displayGameView();

		userInterface.dispose();
	}

}
