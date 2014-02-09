package userinterface;

import java.awt.Graphics;

public class SnakePaintingEvery100Milliseconds extends Thread {

	private SnakePainter snakePainter;
	private Graphics graphics;
	private boolean snakePainterPaintsRegularly;

	public SnakePaintingEvery100Milliseconds(SnakePainter snakePainter, Graphics graphics) {
		super();
		this.snakePainter = snakePainter;
		this.graphics = graphics;
	}

	@Override
	public void run() {
		while (true) {
			snakePainter.paint(graphics);
			try {
				Thread.sleep(100);
				snakePainter.setPaintsRegularly(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
