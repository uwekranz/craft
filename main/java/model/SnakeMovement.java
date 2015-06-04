package model;

public class SnakeMovement extends Thread {

	private static final int TICKER_DURATION = 100;
	static final int STEP_DISTANCE = 10;

	static Direction direction = Direction.RIGHT;

	private Snake snake;

	public SnakeMovement(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void run() {
		while (true) {
			snake.move(direction, STEP_DISTANCE);
			try {
				Thread.sleep(TICKER_DURATION);
			} catch (InterruptedException exception) {
				throw new RuntimeException(exception);
			}
		}
	}

	public static Direction getDirection() {
		return direction;
	}

	public static void setDirection(Direction newDirection) {
		direction = newDirection;
	}
}
