package model;

public class SnakeMovement extends Thread {

	private Snake snake;

	public SnakeMovement(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void run() {
		while (true) {
			snake.move();
			try {
				int tickerDuration = 100;
				Thread.sleep(tickerDuration);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
				throw new RuntimeException(exception);
			}
		}
	}

}
