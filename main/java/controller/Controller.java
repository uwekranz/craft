package controller;

import java.awt.Dimension;

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

	public void replaceGameModelByInitialGameModel() {
		gameModel = new GameModel();
	}

	public void setDimensionsOfSnakeCage(Dimension dimensions) {
		gameModel.setDimensionsOfSnakeCage(dimensions);
	}

}
