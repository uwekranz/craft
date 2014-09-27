package view;

import java.awt.Graphics;

import model.Axis;
import model.GameModel;
import model.Location;

public class SnakePainter {

	private GameModel model;

	public SnakePainter(GameModel model) {
		this.model = model;
	}

	public void paint(Graphics graphics) {
		Location snakeLocation = model.getSnakeLocation();
		graphics.drawLine(snakeLocation.getCoordinate(Axis.HORIZONTAL_AXIS),
				snakeLocation.getCoordinate(Axis.VERTICAL_AXIS),
				snakeLocation.getCoordinate(Axis.HORIZONTAL_AXIS) + 100,
				snakeLocation.getCoordinate(Axis.VERTICAL_AXIS));
	}

}
