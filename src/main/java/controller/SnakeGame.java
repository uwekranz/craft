package controller;

import javax.swing.JOptionPane;

import model.GameModel;
import view.UserInterface;

public class SnakeGame {

	private GameModel gameModel;
	private Controller controller;
	private UserInterface userInterface;

	public SnakeGame() {
		initialize();
	}

	public void start() {
		letViewObserveModel(gameModel, userInterface);
		userInterface.displayGameView();
	}

	public void restart() {
		JOptionPane.getRootFrame().dispose();
		userInterface.dispose();

		initialize();

		letViewObserveModel(gameModel, userInterface);
		userInterface.displayGameView();
	}

	private void initialize() {
		gameModel = new GameModel();
		controller = new Controller(gameModel);
		userInterface = new UserInterface(controller);
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
