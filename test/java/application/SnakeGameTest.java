package application;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import userinterface.UserInterface;

public class SnakeGameTest {

	SnakeGame snakeGame = new SnakeGame();

	@Test
	public void itShouldNotCrashOnRunningItsMainMethod() {
		SnakeGame.main(null);
	}

	@Test
	public void itShouldDisplayTheUserInterfaceWhenStarted() {
		UserInterface userInterface = mock(UserInterface.class);
		snakeGame.setUserInterface(userInterface);
		snakeGame.start();
		verify(userInterface).display();
	}
}
