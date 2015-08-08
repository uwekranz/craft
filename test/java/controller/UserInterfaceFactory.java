package controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import model.GameModel;
import model.Snake;
import model.SnakeLocation;
import view.UserInterface;

public class UserInterfaceFactory {

	public static UserInterface createMock() {
		GameModel gameModel = mock(GameModel.class);
		SnakeLocation snakeLocation = new SnakeLocation(Snake.INITIAL_BODY_LENGTH);
		when(gameModel.getSnakeLocation()).thenReturn(snakeLocation);

		Controller controller = mock(Controller.class);
		when(controller.getGameModel()).thenReturn(gameModel);

		return new UserInterface(controller);
	}

}
