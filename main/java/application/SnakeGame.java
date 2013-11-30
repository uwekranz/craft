package application;

import userinterface.UserInterface;

public class SnakeGame {

	static UserInterface userInterface;

	public static void main(String[] arguments) {
		SnakeGame.start(new UserInterface());
	}

	public static void start(UserInterface userInterface) {
		SnakeGame.userInterface = userInterface;
		userInterface.display();
	}

	public static UserInterface getUserInterface() {
		return userInterface;
	}
}
