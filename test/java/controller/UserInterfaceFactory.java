package controller;

import static org.mockito.Mockito.mock;
import model.ControllerFactory;
import model.GameModel;
import model.GameModelFactory;
import view.FoodPainter;
import view.SnakePainter;
import view.UserInterface;

public class UserInterfaceFactory {

	public static UserInterface createMockWithFoodPainter(FoodPainter foodPainter) {
		UserInterface userInterface = createMock();
		userInterface.setFoodPainter(foodPainter);

		return userInterface;
	}

	public static UserInterface createMock() {
		return createMockWithSnakePainter(mock(SnakePainter.class));
	}

	public static UserInterface createMockWithSnakePainter(SnakePainter snakePainter) {
		GameModel gameModel = GameModelFactory.createGameModelMock();
		Controller controller = ControllerFactory.createControllerMock(gameModel, mock(Controller.class));
		FoodPainter foodPainter = mock(FoodPainter.class);

		return createUserInterfaceWith(snakePainter, controller, foodPainter);
	}

	private static UserInterface createUserInterfaceWith(SnakePainter snakePainter, Controller controller, FoodPainter foodPainterMock) {
		UserInterface userInterface = new UserInterface(controller);
		userInterface.setSnakePainter(snakePainter);
		userInterface.setFoodPainter(foodPainterMock);

		return userInterface;
	}

	public static UserInterface createMockWithController(Controller controller) {
		return createUserInterfaceWith(mock(SnakePainter.class), controller, mock(FoodPainter.class));
	}
}
