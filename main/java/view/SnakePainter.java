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
		graphics.drawLine(snakeLocation.getCoordinate(Axis.HORIZONTAL),
				snakeLocation.getCoordinate(Axis.VERTICAL),
				snakeLocation.getCoordinate(Axis.HORIZONTAL) + 100,
				snakeLocation.getCoordinate(Axis.VERTICAL));
	}

}
