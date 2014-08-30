package controller;

import model.GameModel;
import view.UserInterface;

public class SnakeGame {

	GameModel model = new GameModel();
	public void startWithUserInterface(UserInterface userInterface) {
		userInterface.displayView();
	}

	public GameModel getModel() {
		return model;
	}

}
