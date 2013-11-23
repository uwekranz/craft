package application;

import userinterface.UserInterface;

public class SnakeGame {

	UserInterface userInterface;

	public SnakeGame() {
		this.userInterface = new UserInterface();
	}

	public SnakeGame(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public static void main(String[] arguments) {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.start();
	}

	public void start() {
		userInterface.display();
	}

	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

	public UserInterface getUserInterface() {
		return userInterface;
	}
}
