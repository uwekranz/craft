package view.fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import model.GameModel;
import view.FoodPainter;
import view.SnakePainter;

import java.awt.*;

import static java.awt.Color.RED;


public class SnakeCageViewFX extends Stage {

	private static final long serialVersionUID = 1L;

	private SnakePainterFX snakePainter;
	private FoodPainterFX foodPainter;

	private Boolean isPaintedRegularly = false;

	public SnakeCageViewFX(GameModel gameModel) {
		snakePainter = new SnakePainterFX(gameModel);
		foodPainter = new FoodPainterFX(gameModel);
	}

	private void paintSnake(GraphicsContext graphics) {
		snakePainter.paint(graphics);
	}

	private void paintFood(GraphicsContext graphics) {
		foodPainter.paint(graphics);
	}

	protected Boolean hasFoodBeenPainted() {
		return foodPainter.hasFoodBeenPainted();
	}

	protected SnakePainterFX getSnakePainter() {
		return snakePainter;
	}

	protected void paintComponent(GraphicsContext graphics) {
		paintFood(graphics);
		paintSnake(graphics);
	}

	public void repaintGameViewRegularly(SnakeCageViewFX gameView) {
		GameViewRepainterFX gameViewRepainter = new GameViewRepainterFX(gameView);
		gameViewRepainter.start();
	}

	public Boolean isPaintedRegularly() {
		return isPaintedRegularly;
	}

	public void setIsPaintedRegularly(boolean isPaintedRegularly) {
		this.isPaintedRegularly = isPaintedRegularly;
	}

	protected void setSnakePainter(SnakePainterFX snakePainter) {
		this.snakePainter = snakePainter;
	}

	public boolean snakeHasBeenPainted() {
		return snakePainter.hasSnakeBeenPainted();
	}

	public Dimension getDimensions() {
		double width = getWidth();
		double height = getHeight();
		return new Dimension((int )width, (int) height);
	}

	public void setFoodPainter(FoodPainterFX foodPainter) {
		this.foodPainter = foodPainter;
	}

	public void repaint() {
	}
}
