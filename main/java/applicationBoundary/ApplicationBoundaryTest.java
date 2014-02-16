package applicationBoundary;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import controller.SnakeGame;
import applicationBoundary.ApplicationBoundary;
import view.UserInterface;

public class ApplicationBoundaryTest {

	ApplicationBoundary applicationBoundary = new ApplicationBoundary();

	@Test
	public void itShould_NotCrash_WhenRunningItsMainMethod() {
		ApplicationBoundary.main(null);
	}

	@Test
	public void itShould_DisplayTheUserInterface_WhenStarted() {
		UserInterface userInterface = mock(UserInterface.class);
		new SnakeGame().startWithUserInterface(userInterface);
		verify(userInterface).displayView();
	}

}
