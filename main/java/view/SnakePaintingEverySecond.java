package view;

import java.awt.Graphics;

public class SnakePaintingEverySecond extends Thread {

	private SnakePainter snakePainter;
	private Graphics graphics;

	public SnakePaintingEverySecond(SnakePainter snakePainter, Graphics graphics) {
		super();
		this.snakePainter = snakePainter;
		this.graphics = graphics;
	}

	@Override
	public void run() {
		while (true) {
			snakePainter.paint(graphics);
			try {
				snakePainter.setPaintsRegularly(true);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
