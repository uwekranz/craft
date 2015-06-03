package view;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;
import static model.BodyPart.TAIL;

import java.awt.Graphics;

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
		graphics.drawLine(snakeLocation.getCoordinate(TAIL, HORIZONTAL_AXIS), snakeLocation.getCoordinate(TAIL, VERTICAL_AXIS), snakeLocation.getCoordinate(TAIL, HORIZONTAL_AXIS)
				+ model.getSnakeBodyLength(), snakeLocation.getCoordinate(TAIL, VERTICAL_AXIS));
		hasSnakeBeenPainted = true;
	}

	public boolean hasSnakeBeenPainted() {
		return hasSnakeBeenPainted;

	}

}
