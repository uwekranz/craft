package userinterface;

import java.awt.Graphics;

public class FoodPainter {

	private static boolean foodHasBeenPainted;

	public static void paint(Graphics graphics) {
		graphics.drawOval(500, 500, 25, 25);
		foodHasBeenPainted = true;
	}

	public static boolean hasFoodBeenPainted() {
		return foodHasBeenPainted;
	}

}
