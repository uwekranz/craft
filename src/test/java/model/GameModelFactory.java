package model;

import static model.Snake.INITIAL_BODY_LENGTH;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameModelFactory {

	public static GameModel createMock() {
		GameModel gameModel = mock(GameModel.class);

		SnakeLocation snakeLocation = new SnakeLocation(INITIAL_BODY_LENGTH);
		when(gameModel.getSnakeLocation()).thenReturn(snakeLocation);
		Food food = new Food();
		when(gameModel.getFood()).thenReturn(food);
		Location foodLocation = food.getLocation();
		when(gameModel.getLocationOfFood()).thenReturn(foodLocation);

		return gameModel;
	}
}
