package model;

public class SnakeMovement extends Thread {

	private int TICKER_DURATION = 100;
	final int STEP_DISTANCE = 10;
	Direction direction = Direction.RIGHT;

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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction newDirection) {
		direction = newDirection;
	}
}
