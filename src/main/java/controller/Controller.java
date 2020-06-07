package controller;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import model.Direction;
import model.GameModel;
import view.fx.UserInterfaceFX;

public class Controller implements Observer {

	GameModel gameModel;
	UserInterfaceFX userInterface;

	public Controller(GameModel model, UserInterfaceFX userInterface) {
		this.gameModel = model;
		this.userInterface = userInterface;
		model.getSnake().addObserver(this);
	}

	public void setDirectionOfSnakeMovement(Direction direction) {
		gameModel.letSnakeMoveInDirection(direction);
	}

	public GameModel getGameModel() {
		return gameModel;
	}

	public void replaceCurrentGameModelWithNewGameModel() {
		gameModel = new GameModel();
	}

	public void setDimensionsOfSnakeCage(Dimension dimensions) {
		gameModel.setDimensionsOfSnakeCage(dimensions);
	}

	@Override
	public void update(Observable observable, Object o) {
		userInterface.fireGameOverEvent();
	}
}
