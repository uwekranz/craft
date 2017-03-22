package model;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import controller.Controller;

public class ControllerFactory {

	public static Controller createControllerMock(GameModel gameModel, Controller controller) {
		when(controller.getGameModel()).thenReturn(gameModel);
		return controller;
	}

	public static Controller createControllerMock(GameModel gameModel) {
		Controller controller = Mockito.mock(Controller.class);
		when(controller.getGameModel()).thenReturn(gameModel);
		return controller;
	}

	public static Controller createControllerMock() {
		GameModel gameModel = GameModelFactory.createMock();
		return createControllerMock(gameModel);
	}

}
