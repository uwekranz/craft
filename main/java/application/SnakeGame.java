package application;

import userinterface.UserInterface;

public class SnakeGame {

	UserInterface userInterface;

	public void main(String[] arguments) {
		startWithUserInsterface(new UserInterface());
	}

	public void startWithUserInsterface(UserInterface userInterface) {
		this.userInterface = userInterface;
		userInterface.display();
	}

	public UserInterface getUserInterface() {
		return userInterface;
	}
}
