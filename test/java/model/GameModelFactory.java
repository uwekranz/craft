package model;

import static model.Snake.INITIAL_BODY_LENGTH;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameModelFactory {

	public static GameModel createGameModelMock() {
		GameModel gameModel = mock(GameModel.class);
		SnakeLocation snakeLocation = new SnakeLocation(INITIAL_BODY_LENGTH);
		when(gameModel.getSnakeLocation()).thenReturn(snakeLocation);
		when(gameModel.getFood()).thenReturn(new Food());
	
		return gameModel;
	}

}
