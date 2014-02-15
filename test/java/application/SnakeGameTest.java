package application;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import userinterface.UserInterface;

public class SnakeGameTest {

	UserInterface userInterface = mock(UserInterface.class);
	SnakeGame snakeGame = new SnakeGame();

	@Test
	public void itShould_NotCrash_WhenRunningItsMainMethod() {
		snakeGame.main(null);
	}

	@Test
	public void itShould_DisplayTheUserInterface_WhenStarted() {
		snakeGame.startWithUserInsterface(userInterface);
		verify(userInterface).display();
	}
}
