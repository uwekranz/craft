package applicationBoundary;

import model.GameModel;
import view.UserInterface;
import controller.Controller;
import controller.SnakeGame;

public class ApplicationBoundary {

	public static void main(String[] arguments) {
		GameModel gameModel = new GameModel();
		Controller controller = new Controller(gameModel);
		UserInterface userInterface = new UserInterface(controller);

		letViewObserveModel(gameModel, userInterface);

		new SnakeGame().startWithUserInterface(userInterface);
	}

	private static void letViewObserveModel(GameModel gameModel, UserInterface userInterface) {
		gameModel.getSnake().addObserver(userInterface);
	}

}
