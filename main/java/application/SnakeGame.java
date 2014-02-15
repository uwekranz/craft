package application;

import userinterface.UserInterface;

public class SnakeGame {

	public void main(String[] arguments) {
		startWithUserInsterface(new UserInterface());
	}

	public void startWithUserInsterface(UserInterface userInterface) {
		userInterface.displayGameView();
	}

}
