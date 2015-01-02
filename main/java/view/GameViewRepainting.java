package view;

public class GameViewRepainting extends Thread {

	private GameView gameView;
	private int tickerDuration;

	public GameViewRepainting(GameView gameView) {
		super();
		this.gameView = gameView;
	}

	@Override
	public void run() {
		while (true) {
			gameView.repaint();
			gameView.setIsPaintedRegularly(true);
			try {
				tickerDuration = 100;
				Thread.sleep(tickerDuration);
			} catch (InterruptedException e) {
				e.printStackTrace();
				gameView.setIsPaintedRegularly(false);
				throw new RuntimeException();
			}
		}
	}
}
