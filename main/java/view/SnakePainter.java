package view;

import java.awt.Graphics;

import model.GameModel;
import model.Location;

public class SnakePainter {

	private GameModel model;

	public SnakePainter(GameModel model) {
		this.model = model;
	}

	public void paint(Graphics graphics) {
		Location snakeLocation = model.getSnakeLocation();
		graphics.drawLine(snakeLocation.getHorizontalCoordinate(),
				snakeLocation.getVerticalCoordinate(),
				snakeLocation.getHorizontalCoordinate() + 100,
				snakeLocation.getVerticalCoordinate());
	}

}
