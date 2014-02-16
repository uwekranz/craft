package application;

import userinterface.UserInterface;

public class ApplicationBoundary {

	public static void main(String[] arguments) {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.startWithUserInsterface(new UserInterface());
	}

}
