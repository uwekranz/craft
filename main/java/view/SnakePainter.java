package view;

import static model.Model.getSnakeLocation;

import java.awt.Graphics;
import java.awt.Point;

public class SnakePainter {

	private boolean hasPainted = false;

	public void paint(Graphics graphics) {
		Point snakeLocation = getSnakeLocation();
		graphics.drawLine(snakeLocation.x, snakeLocation.y, snakeLocation.x + 100, 100);
		hasPainted = true;
	}

	public boolean hasPainted() {
		return hasPainted;
	}

}
