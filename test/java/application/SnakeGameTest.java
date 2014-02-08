package application;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import userinterface.UserInterface;

public class SnakeGameTest {

	UserInterface userInterface = mock(UserInterface.class);

	@Test
	public void itShould_NotCrash_WhenRunningItsMainMethod() {
		new SnakeGame().main(null);
	}

	@Test
	public void itShould_DisplayTheUserInterface_WhenStarted() {
		new SnakeGame().start(userInterface);
		verify(userInterface).display();
	}
}
