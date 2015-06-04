package model;

public class SnakeMovement extends Thread {

	private static final int TICKER_DURATION = 100;
	static final int STEP_DISTANCE = 10;

	private Snake snake;

	public SnakeMovement(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void run() {
		while (true) {
			snake.move(STEP_DISTANCE);
			try {
				Thread.sleep(TICKER_DURATION);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
				throw new RuntimeException(exception);
			}
		}
	}

}
