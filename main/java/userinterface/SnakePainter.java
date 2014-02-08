package userinterface;

import java.awt.Graphics;

public class SnakePainter {

	private boolean hasPainted = false;
	private boolean paintsRegularly = false;

	public void paint(Graphics graphics) {
		graphics.drawLine(1000, 100, 100, 100);
		hasPainted = true;
	}

	public boolean hasPainted() {
		return hasPainted;
	}

	public boolean paintsRegularly() {
		return paintsRegularly;
	}

	public void paintRegularly(Graphics graphics) {
		paint(graphics);
		new Thread() {

			@Override
			public void run() {
				paintsRegularly = true;
				super.run();
			}
		}.start();
	}

}
