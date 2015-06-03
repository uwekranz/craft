package model;

public class SnakeMovement extends Thread {

	private Snake snake;
	private static final int TICKER_DURATION = 100;

	public SnakeMovement(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void run() {
		while (true) {
			snake.move();
			try {
				Thread.sleep(TICKER_DURATION);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
				throw new RuntimeException(exception);
			}
		}
	}

}
