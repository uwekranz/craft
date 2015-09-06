package controller;

import java.awt.Dimension;

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
		setCageDimensionsInModelAccordingToView();
	}

	private void setCageDimensionsInModelAccordingToView() {
		Dimension dimensions = userInterface.getSnakeCageView().getDimensions();
		controller.setDimensionsOfSnakeCage(dimensions);
	}

	public void restart() {
		JOptionPane.getRootFrame().dispose();
		userInterface.dispose();

		gameModel = new GameModel();
		controller = new Controller(gameModel);
		userInterface = new UserInterface(controller);

		letViewObserveModel(gameModel, userInterface);

		userInterface.displayGameView();

		setCageDimensionsInModelAccordingToView();
	}

	private static void letViewObserveModel(GameModel gameModel, UserInterface userInterface) {
		gameModel.getSnake().addObserver(userInterface);
	}

	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public void end() {
		JOptionPane.getRootFrame().dispose();
		userInterface.dispose();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
