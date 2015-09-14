package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.awt.Graphics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import controller.UserInterfaceFactory;

public class UserInterfaceTest {

	private UserInterface userInterface;
	private SnakePainter snakePainter;

	@Before
	public void prepareTests() throws InterruptedException {
		snakePainter = Mockito.mock(SnakePainter.class);
		userInterface = UserInterfaceFactory.createMockWithSnakePainter(snakePainter);
	}

	@Test
	public void itShould_BeVisible_WhenViewHasBeenDisplayed() {
		userInterface.displayGameView();
		assertThat(userInterface.isVisible(), is(true));
	}

	@Test
	public void itIsNotPaintedRegularlyYet_WhenItIsNewlyCreated() {
		assertThat(userInterface.isPaintedRegularly(), is(false));
	}

	@Test
	public void itShouldHaveLetSnakeBePainted_WhenViewHasBeenDisplayed() {
		userInterface.displayGameView();
		verify(snakePainter, atLeastOnce()).paint(any(Graphics.class));
	}

	@Test
	public void itShouldPaintRegularly_WhenViewHasBeenDisplayed() throws Exception {
		userInterface.displayGameView();
		Thread.sleep(10);
		assertThat(userInterface.isPaintedRegularly(), is(true));
	}

	@After
	public void tearDown() {
		userInterface.dispose();
	}

}
