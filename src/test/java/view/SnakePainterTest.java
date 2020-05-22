package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javafx.stage.Stage;
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
	}

	@Test
	public void itIsNotPaintedRegularlyYet_WhenItIsNewlyCreated() {
		assertThat(userInterface.isPaintedRegularly(), is(false));
	}

	@Test
	public void itShouldHavePainted_WhenGameHasStarted() {
		snakeGame.start();
		assertThat(snakeHasBeenPainted(snakeGame), is(true));
	}

	private Boolean snakeHasBeenPainted(SnakeGame snakeGame) {
		return userInterface.getGameView().snakeHasBeenPainted();
	}

	@Test
	public void itShouldPaintRegularly_WhenGameHasStarted() throws InterruptedException {
		snakeGame.start();
		// TODO Sep 6, 2015 - ano: get rid of sleep
		Thread.sleep(100);
		assertThat(userInterface.isPaintedRegularly(), is(true));
	}

	@After
	public void tearDown() {
		userInterface.dispose();
	}

}
