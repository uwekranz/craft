package view;

import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_H;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import model.Direction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import applicationBoundary.SnakeGameLogger;
import controller.Controller;

public class KeyListeningTest {

	private UserInterface userInterface;

	private SnakePainter snakePainterMock;
	private Controller controllerMock;

	@Before
	public void setUp() throws InterruptedException {
		controllerMock = mock(Controller.class);
		userInterface = new UserInterface(controllerMock);
		snakePainterMock = mock(SnakePainter.class);
		userInterface.setSnakePainter(snakePainterMock);

		userInterface.displayGameView();
		waitForUserInterfaceToGainFocus();
	}

	@Test
	public void whenKeyDownIsPressed_directionOfSnakeMovementGetsSetAccordingly() {
		whenTheUserPressesTheKey(VK_DOWN).thenTheSnakesDirectionGetsSetTo(DOWN);
	}

	@Test
	public void whenKeyUpIsPressed_directionOfSnakeMovementGetsSetAccordingly() {
		whenTheUserPressesTheKey(VK_UP).thenTheSnakesDirectionGetsSetTo(UP);
	}

	@Test
	public void whenKeyLeftIsPressed_directionOfSnakeMovementGetsSetAccordingly() {
		whenTheUserPressesTheKey(VK_LEFT).thenTheSnakesDirectionGetsSetTo(LEFT);
	}

	@Test
	public void whenKeyRightIsPresses_theDirectionOfSnakeMovementGetsSetAccordingly() {
		whenTheUserPressesTheKey(VK_RIGHT).thenTheSnakesDirectionGetsSetTo(RIGHT);
	}

	@Test
	public void whenANonArrowKeyIsPressed_theDirectionOfSnakeMovementDoesNotChange() {
		KeyPresser.pressKeyWithCode(VK_H);
		verify(controllerMock, never()).setDirectionOfSnakeMovement(Mockito.any(Direction.class));
	}

	private AssertionBuilder whenTheUserPressesTheKey(int keyCode) {
		KeyPresser.pressKeyWithCode(keyCode);
		return new AssertionBuilder(controllerMock);
	}

	@After
	public void tearDown() {
		userInterface.dispose();
	}

	private void waitForUserInterfaceToGainFocus() throws InterruptedException {
		int i = 0;
		while (!userInterface.snakeCageViewHasFocus()) {
			SnakeGameLogger.debug(this, "Waiting for user interface to gain focus ...");
			Thread.sleep(10);
			i++;
			if (i > 40)
				throw new RuntimeException();
		}
	}
}
