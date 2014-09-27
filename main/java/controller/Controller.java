package controller;

import model.Direction;
import model.GameModel;

public class Controller {

	GameModel gameModel;

	public Controller(GameModel model) {
		this.gameModel = model;
	}

	public void setDirectionOfSnakeMovement(Direction direction) {
		gameModel.letSnakeMoveInDirection(direction);
	}

	public GameModel getGameModel() {
		return gameModel;
	}

}
