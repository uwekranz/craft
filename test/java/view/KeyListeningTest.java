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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

		userInterface.displayView();
		Thread.sleep(1000);
	}

	@Test
	public void whenDownKeyIsPressed_directionOfSnakeMovementGetsSetAccordingly()
			throws Exception {
		whenTheUserPressesTheKey(VK_DOWN).thenTheSnakesDirectionGetsSetTo(DOWN);
	}

	@Test
	public void whenUpKeyIsPressed_directionOfSnakeMovementGetsSetAccordingly()
			throws Exception {
		whenTheUserPressesTheKey(VK_UP).thenTheSnakesDirectionGetsSetTo(UP);
	}

	// TODO: 01.06.2015, make this test reliable
	@Test
	public void whenKeyRightIsPresses_theDirectionOfSnakeMovementGetsSetAccordingly()
			throws Exception {
		whenTheUserPressesTheKey(VK_RIGHT).thenTheSnakesDirectionGetsSetTo(
				RIGHT);
	}

	@Test
	public void whenKeyLeftIsPressed_directionOfSnakeMovementGetsSetAccordingly()
			throws Exception {
		whenTheUserPressesTheKey(VK_LEFT).thenTheSnakesDirectionGetsSetTo(LEFT);
	}

	@Test
	public void whenANonArrowKeyIsPressed_theDirectionOfSnakeMovementDoesNotChange()
			throws Exception {
		KeyPresser.pressKeyWithCode(VK_H);
		verify(controllerMock, never()).setDirectionOfSnakeMovement(
				Mockito.any(Direction.class));
	}

	private AssertionBuilder whenTheUserPressesTheKey(int keyCode) {
		AssertionBuilder assertionBuilder = new AssertionBuilder(controllerMock);
		KeyPresser.pressKeyWithCode(keyCode);

		return assertionBuilder;
	}
}
