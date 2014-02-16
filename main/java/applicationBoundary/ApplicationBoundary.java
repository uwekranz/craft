package applicationBoundary;

import controller.SnakeGame;
import view.UserInterface;

public class ApplicationBoundary {

	public static void main(String[] arguments) {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.startWithUserInterface(new UserInterface());
	}

}
