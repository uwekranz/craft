package view.fx;

import javafx.scene.canvas.GraphicsContext;
import model.GameModel;
import model.Location;

import java.awt.*;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

public class FoodPainterFX {

	private boolean foodHasBeenPainted;
	private GameModel gameModel;

	public FoodPainterFX(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	public void paint(GraphicsContext graphics) {
		Location foodLocation = gameModel.getLocationOfFood();
		int horizontalCoordinate = foodLocation.getCoordinate(HORIZONTAL_AXIS);
		int verticalCoordinate = foodLocation.getCoordinate(VERTICAL_AXIS);
		int sizeOfFood = gameModel.getSizeOfFood();
		graphics.fillRect(horizontalCoordinate - sizeOfFood / 2, verticalCoordinate - sizeOfFood / 2, sizeOfFood, sizeOfFood);

		foodHasBeenPainted = true;
	}

	public boolean hasFoodBeenPainted() {
		return foodHasBeenPainted;
	}

}
