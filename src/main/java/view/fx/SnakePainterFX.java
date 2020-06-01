package view.fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.GameModel;
import model.Location;
import model.SnakeLocation;
import java.util.List;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

public class SnakePainterFX {

	private GameModel model;
	private boolean hasSnakeBeenPainted = false;

	public SnakePainterFX(GameModel model) {
		this.model = model;
	}

	public void paint(GraphicsContext graphics) {
		SnakeLocation snakeLocation = model.getSnakeLocation();
		List<Location> bodyParts = snakeLocation.getBodyParts();

		for (int index = 0; index < bodyParts.size() - 1; index++) {
			Location firstPoint = bodyParts.get(index);
			Location secondPoint = bodyParts.get(index + 1);

			graphics.setStroke(Color.RED);
			graphics.setLineWidth(10);

			graphics.strokeLine(firstPoint.getCoordinate(HORIZONTAL_AXIS), firstPoint.getCoordinate(VERTICAL_AXIS),
					secondPoint.getCoordinate(HORIZONTAL_AXIS), secondPoint.getCoordinate(VERTICAL_AXIS));
		}

		hasSnakeBeenPainted = true;
	}

	public boolean hasSnakeBeenPainted() {
		return hasSnakeBeenPainted;

	}

}
