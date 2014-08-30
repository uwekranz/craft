package applicationBoundary;

import view.UserInterface;
import controller.Controller;
import controller.SnakeGame;

public class ApplicationBoundary {

	public static void main(String[] arguments) {
		SnakeGame snakeGame = new SnakeGame();
		Controller controller = new Controller();
		UserInterface userInterface = new UserInterface(controller);
		snakeGame.startWithUserInterface(userInterface);
	}

}
