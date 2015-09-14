package view;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

import java.awt.Graphics;

import model.Food;
import model.Location;

public class FoodPainter {

	private boolean foodHasBeenPainted;
	private Food food;

	public FoodPainter(Food food) {
		this.food = food;
	}

	public void paint(Graphics graphics) {
		Location foodLocation = food.getLocation();
		int horizontalCoordinate = foodLocation.getCoordinate(HORIZONTAL_AXIS);
		int verticalCoordinate = foodLocation.getCoordinate(VERTICAL_AXIS);
		int sizeOfFood = food.getSize();
		graphics.drawOval(horizontalCoordinate, verticalCoordinate, sizeOfFood, sizeOfFood);
		foodHasBeenPainted = true;
	}

	public boolean hasFoodBeenPainted() {
		return foodHasBeenPainted;
	}

}
