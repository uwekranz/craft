package userinterface;

import java.awt.Graphics;

public class SnakePainter {

	private boolean snakeHasBeenPainted = false;

	public void paint(Graphics graphics) {
		graphics.drawLine(1000, 100, 100, 100);
		snakeHasBeenPainted = true;
	}

	public Boolean hasSnakeBeenPainted() {
		return snakeHasBeenPainted;
	}

}
