package application;

import userinterface.UserInterface;

public class SnakeGame {

	public static void main(String[] arguments) {
		startWithUserInsterface(new UserInterface());
	}

	public static void startWithUserInsterface(UserInterface userInterface) {
		userInterface.displayGameView();
	}

}
