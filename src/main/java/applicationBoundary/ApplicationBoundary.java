package applicationBoundary;

import controller.SnakeGame;
import javafx.stage.Stage;

public class ApplicationBoundary {

	private static SnakeGame snakeGame;

	public static void startNewGame() {
		main(null);
	}

	public static void main(String[] arguments) {
		snakeGame = new SnakeGame();
		snakeGame.start();
	}

	public static void restart() {
		snakeGame.restart();
	}
}
