package userinterface;

import java.awt.Graphics;

public class SnakePainter {

	private static boolean snakeHasBeenPainted = false;

	public static void paintSnake(Graphics graphics) {
		graphics.drawLine(1000, 100, 100, 100);
		snakeHasBeenPainted = true;
	}

	public static Boolean hasSnakeBeenPainted() {
		return snakeHasBeenPainted;
	}

}
