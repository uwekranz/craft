package view;

public class GameViewRepainter extends Thread {

	private SnakeCageView gameView;
	private int tickerDuration;

	public GameViewRepainter(SnakeCageView gameView) {
		super();
		this.gameView = gameView;
	}

	@Override
	public void run() {
		while (true) {
			gameView.repaint();
			gameView.setIsPaintedRegularly(true);
			try {
				tickerDuration = 20;
				Thread.sleep(tickerDuration);
			} catch (InterruptedException e) {
				gameView.setIsPaintedRegularly(false);
				throw new RuntimeException();
			}
		}
	}
}
