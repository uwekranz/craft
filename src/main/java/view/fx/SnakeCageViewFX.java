package view.fx;

import controller.fx.ArrowKeysHandlerFX;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.GameModel;

import java.awt.*;


public class SnakeCageViewFX extends Stage {

	private static final long serialVersionUID = 1L;

	private SnakePainterFX snakePainter;
	private FoodPainterFX foodPainter;

	private Boolean isPaintedRegularly = false;
	private GraphicsContext graphics;

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
		this.graphics = graphics;
		graphics.setFill(javafx.scene.paint.Color.BLUE);

		repaint();
	}

	public void repaint() {
		Canvas canvas = graphics.getCanvas();
		graphics.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
		paintFood(graphics);
		paintSnake(graphics);
	}

	public void repaintGameViewRegularly() {
		GameViewRepainterFX gameViewRepainter = new GameViewRepainterFX(this);
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


}
