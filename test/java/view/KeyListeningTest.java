package view;

import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_UP;
import static model.Direction.DOWN;
import static model.Direction.UP;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import model.Direction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import controller.Controller;

public class KeyListeningTest {

	private UserInterface userInterface;

	private SnakePainter snakePainterMock;
	private Controller controllerMock;

	@Captor
	ArgumentCaptor<Direction> directionCaptor = ArgumentCaptor.forClass(Direction.class);

	@Before
	public void prepareTests() {
		controllerMock = mock(Controller.class);
		userInterface = new UserInterface(controllerMock);
		snakePainterMock = mock(SnakePainter.class);
		userInterface.setSnakePainter(snakePainterMock);
		userInterface.displayView();
	}

	@Test
	public void whenDownKeyIsPressed_directionOfSnakeMovementGetsSetAccordingly() throws Exception {
		pressKey(VK_DOWN);
		assertThat(theNewDirectionOfSnakeMovement(), is(DOWN));
	}

	@Test
	public void whenUpKeyIsPressed_directionOfSnakeMovementGetsSetAccordingly() throws Exception {
		pressKey(VK_UP);
		assertThat(theNewDirectionOfSnakeMovement(), is(UP));
	}

	@Test
	public void whenANonArrowKeyIsPressed_theDirectionOfSnakeMovementDoesNotChange() throws Exception {
		pressKey(KeyEvent.VK_H);
		verify(controllerMock, never()).setDirectionOfSnakeMovement(Mockito.any(Direction.class));

	}

	private void pressKey(int keyEvent) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(keyEvent);
		robot.keyRelease(keyEvent);

		Thread.sleep(200);
	}

	private Direction theNewDirectionOfSnakeMovement() {
		verify(controllerMock).setDirectionOfSnakeMovement(directionCaptor.capture());
		Direction directionOfSnakeMovement = directionCaptor.getValue();
		return directionOfSnakeMovement;
	}
}
