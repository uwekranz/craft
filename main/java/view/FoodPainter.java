package view;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

import java.awt.Graphics;

import model.GameModel;
import model.Location;

public class FoodPainter {

	private boolean foodHasBeenPainted;
	private GameModel gameModel;

	public FoodPainter(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	public void paint(Graphics graphics) {
		Location foodLocation = gameModel.getLocationOfFood();
		int horizontalCoordinate = foodLocation.getCoordinate(HORIZONTAL_AXIS);
		int verticalCoordinate = foodLocation.getCoordinate(VERTICAL_AXIS);
		int sizeOfFood = gameModel.getSizeOfFood();
		graphics.drawOval(horizontalCoordinate, verticalCoordinate, sizeOfFood, sizeOfFood);
		foodHasBeenPainted = true;
	}

	public boolean hasFoodBeenPainted() {
		return foodHasBeenPainted;
	}

}
