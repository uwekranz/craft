package view;

import java.awt.Graphics;
import java.awt.Point;

import model.GameModel;

public class SnakePainter {

	private GameModel model;

	public SnakePainter(GameModel model) {
		this.model = model;
	}

	public void paint(Graphics graphics) {
		Point snakeLocation = model.getSnakeLocation();
		graphics.drawLine(snakeLocation.x, snakeLocation.y,
				snakeLocation.x + 100, snakeLocation.y);
	}

}
