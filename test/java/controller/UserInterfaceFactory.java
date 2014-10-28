package controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import model.GameModel;
import model.SnakeLocation;
import view.UserInterface;

public class UserInterfaceFactory {

	public static UserInterface createMock() {
		Controller controller = mock(Controller.class);
		GameModel gameModel = mock(GameModel.class);
		when(gameModel.getSnakeLocation()).thenReturn(new SnakeLocation());
		when(controller.getGameModel()).thenReturn(gameModel);
		UserInterface userInterface = new UserInterface(controller);
		return userInterface;
	}

}
