package view;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

import java.awt.Graphics;
import java.util.List;

import model.GameModel;
import model.Location;
import model.SnakeLocation;

public class SnakePainter {

	private GameModel model;
	private boolean hasSnakeBeenPainted = false;

	public SnakePainter(GameModel model) {
		this.model = model;
	}

	public void paint(Graphics graphics) {
		SnakeLocation snakeLocation = model.getSnakeLocation();
		List<Location> bodyParts = snakeLocation.getBodyParts();
		for (int index = 0; index < bodyParts.size() - 1; index++) {
			Location firstPoint = bodyParts.get(index);
			Location secondPoint = bodyParts.get(index + 1);
			graphics.drawLine(firstPoint.getCoordinate(HORIZONTAL_AXIS), firstPoint.getCoordinate(VERTICAL_AXIS), secondPoint.getCoordinate(HORIZONTAL_AXIS),
					secondPoint.getCoordinate(VERTICAL_AXIS));
		}
		hasSnakeBeenPainted = true;

	}

	public boolean hasSnakeBeenPainted() {
		return hasSnakeBeenPainted;

	}

}
