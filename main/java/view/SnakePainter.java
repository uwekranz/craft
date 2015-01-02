package view;

import java.awt.Graphics;

import model.Axis;
import model.GameModel;
import model.SnakeLocation;

public class SnakePainter {

	private GameModel model;
	private boolean hasSnakeBeenPainted = false;

	public SnakePainter(GameModel model) {
		this.model = model;
	}

	public void paint(Graphics graphics) {
		SnakeLocation snakeLocation = model.getSnakeLocation();
		graphics.drawLine(snakeLocation.getCoordinate(Axis.HORIZONTAL_AXIS),
				snakeLocation.getCoordinate(Axis.VERTICAL_AXIS),
				snakeLocation.getCoordinate(Axis.HORIZONTAL_AXIS) + 100,
				snakeLocation.getCoordinate(Axis.VERTICAL_AXIS));
		hasSnakeBeenPainted = true;
	}

	public boolean hasSnakeBeenPainted() {
		return hasSnakeBeenPainted;
		
	}

}
