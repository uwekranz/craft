package applicationBoundary;

import model.GameModel;
import view.UserInterface;
import controller.Controller;
import controller.SnakeGame;

public class ApplicationBoundary {

	public static void main(String[] arguments) {
		SnakeGame snakeGame = new SnakeGame();

		GameModel gameModel = new GameModel();
		Controller controller = new Controller(gameModel);
		UserInterface userInterface = new UserInterface(controller);

		snakeGame.startWithUserInterface(userInterface);
	}

}
