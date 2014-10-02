package view;

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
		createUserInterface_WithMockedSnakePainter();
		userInterface.displayView();
	}

	private void createUserInterface_WithMockedSnakePainter() {
		controllerMock = mock(Controller.class);
		userInterface = new UserInterface(controllerMock);
		snakePainterMock = mock(SnakePainter.class);
		userInterface.setSnakePainter(snakePainterMock);
	}

	@Test
	public void whenDownKeyIsPressed_directionOfSnakeMovementGetsSetAccordingly() throws Exception {
		pressKey(KeyEvent.VK_DOWN);
		assertThat(theNewDirectionOfSnakeMovement(), is(Direction.DOWN));
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
