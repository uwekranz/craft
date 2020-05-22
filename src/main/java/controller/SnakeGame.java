package controller;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import model.GameModel;
import view.UserInterface;
import view.fx.UserInterfaceFX;

public class SnakeGame {

	private GameModel gameModel = new GameModel();
	private Controller controller = new Controller(gameModel);
	private UserInterface userInterface = new UserInterface(controller);

	public void start() {
		letViewObserveModel(gameModel, userInterface);
		UserInterfaceFX.main(null);
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
