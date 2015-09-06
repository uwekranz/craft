package controller;

import javax.swing.JOptionPane;

import model.GameModel;
import view.UserInterface;

public class SnakeGame {

	private UserInterface userInterface;
	private GameModel gameModel;
	private Controller controller;

	public void start() {
		gameModel = new GameModel();
		controller = new Controller(gameModel);
		userInterface = new UserInterface(controller);

		letViewObserveModel(gameModel, userInterface);

		userInterface.displayGameView();
	}

	public void restart() {
		JOptionPane.getRootFrame().dispose();
		userInterface.dispose();

		gameModel = new GameModel();
		controller = new Controller(gameModel);
		userInterface = new UserInterface(controller);

		letViewObserveModel(gameModel, userInterface);

		userInterface.displayGameView();
	}

	private static void letViewObserveModel(GameModel gameModel, UserInterface userInterface) {
		gameModel.getSnake().addObserver(userInterface);
	}

	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public UserInterface getUserInterface() {
		return userInterface;
	}

}
