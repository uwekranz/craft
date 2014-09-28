package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Graphics;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;

public class UserInterfaceTest {

	private UserInterface userInterface;

	private SnakePainter snakePainterMock;
	private Controller controllerMock;

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
	public void itShould_BeVisible_WhenViewHasBeenDisplayed() {
		assertThat(userInterface.isVisible(), is(true));
	}

	@Test
	public void itIsNotPaintedRegularlyYet_WhenItIsNewlyCreated() {
		assertThat(userInterface.isPaintedRegularly(), is(false));
	}

	@Test
	public void itShouldHaveLetSnakeBePainted_WhenViewHasBeenDisplayed() {
		verify(snakePainterMock, atLeastOnce()).paint(any(Graphics.class));
	}

	@Test
	public void itShouldPaintRegularly_WhenViewHasBeenDisplayed() throws Exception {
		Thread.sleep(10);
		assertThat(userInterface.isPaintedRegularly(), is(true));
	}

}
