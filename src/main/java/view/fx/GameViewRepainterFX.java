package view.fx;

import view.SnakeCageView;

public class GameViewRepainterFX extends Thread {

	private SnakeCageViewFX gameView;
	private int tickerDuration;

	public GameViewRepainterFX(SnakeCageViewFX gameView) {
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
