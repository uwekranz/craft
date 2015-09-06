package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import model.GameModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import controller.SnakeGame;

public class SnakePainterTest {
	SnakeGame snakeGame;
	UserInterface userInterface;

	@Before
	public void prepareTests() {
		snakeGame = new SnakeGame();
		Controller controller = new Controller(new GameModel());
		userInterface = new UserInterface(controller);
		snakeGame.setUserInterface(userInterface);
		snakeGame.start();
	}

	@Test
	public void itIsNotPaintedRegularlyYet_WhenItIsNewlyCreated() {
		assertThat(userInterface.isPaintedRegularly(), is(false));
	}

	@Test
	public void itShouldHavePainted_WhenGameHasStarted() {
		assertThat(snakeHasBeenPainted(snakeGame), is(true));
	}

	private Boolean snakeHasBeenPainted(SnakeGame snakeGame2) {
		return userInterface.getGameView().snakeHasBeenPainted();
	}

	@Test
	public void itShouldPaintRegularly_WhenGameHasStarted() throws InterruptedException {
		Thread.sleep(100);
		assertThat(userInterface.isPaintedRegularly(), is(true));
	}

	@After
	public void tearDown() {
		userInterface.dispose();
	}

}
