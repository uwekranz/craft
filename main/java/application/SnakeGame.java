package application;

import userinterface.UserInterface;

public class SnakeGame {

	static UserInterface userInterface;

	public void main(String[] arguments) {
		start(new UserInterface());
	}

	public void start(UserInterface userInterface) {
		SnakeGame.userInterface = userInterface;
		userInterface.display();
	}

	public UserInterface getUserInterface() {
		return userInterface;
	}
}
