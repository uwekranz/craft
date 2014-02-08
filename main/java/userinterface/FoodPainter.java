package userinterface;

import java.awt.Graphics;

public class FoodPainter {

	private boolean foodHasBeenPainted;

	public void paint(Graphics graphics) {
		graphics.drawOval(500, 500, 25, 25);
		foodHasBeenPainted = true;
	}

	public boolean hasFoodBeenPainted() {
		return foodHasBeenPainted;
	}

}
