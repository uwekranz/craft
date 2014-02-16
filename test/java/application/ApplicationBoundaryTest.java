package application;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import userinterface.UserInterface;

public class ApplicationBoundaryTest {

	ApplicationBoundary applicationBoundary = new ApplicationBoundary();

	@Test
	public void itShould_NotCrash_WhenRunningItsMainMethod() {
		ApplicationBoundary.main(null);
	}

	@Test
	public void itShould_DisplayTheUserInterface_WhenStarted() {
		UserInterface userInterface = mock(UserInterface.class);
		new SnakeGame().startWithUserInsterface(userInterface);
		verify(userInterface).displayView();
	}

}
