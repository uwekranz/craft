package controller;

import javax.swing.JOptionPane;

import model.GameModel;
import view.UserInterface;
import view.fx.UserInterfaceFX;

public class SnakeGame {

	private GameModel gameModel;
	private Controller controller;
	private UserInterface userInterface;

	public SnakeGame() {
		initialize();
	}

	public void start() {
		UserInterfaceFX.main(null);
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
