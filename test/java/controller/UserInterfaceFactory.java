package controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Point;

import model.GameModel;
import model.Location;
import view.UserInterface;

public class UserInterfaceFactory {

	public static UserInterface createMock() {
		Controller controller = mock(Controller.class);
		GameModel gameModel = mock(GameModel.class);
		when(gameModel.getSnakeLocation())
				.thenReturn(new Location(new Point()));
		when(controller.getGameModel()).thenReturn(gameModel);
		UserInterface userInterface = new UserInterface(controller);
		return userInterface;
	}

}
