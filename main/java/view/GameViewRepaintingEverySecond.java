package view;

public class GameViewRepaintingEverySecond extends Thread {

	private GameView gameView;

	public GameViewRepaintingEverySecond(GameView gameView) {
		super();
		this.gameView = gameView;
	}

	@Override
	public void run() {
		while (true) {
			gameView.repaint();
			gameView.setIsPaintedRegularly(true);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				gameView.setIsPaintedRegularly(false);
				throw new RuntimeException();
			}
		}
	}
}
