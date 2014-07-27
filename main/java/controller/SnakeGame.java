package controller;

import model.Model;
import view.UserInterface;

public class SnakeGame {

	Model model = new Model();
	public void startWithUserInterface(UserInterface userInterface) {
		userInterface.displayView();
	}

	public Model getModel() {
		return model;
	}

}
