package view;

import java.awt.Graphics;

public class CagePainter {

	private boolean cageHasBeenPainted = false;

	public void paint(Graphics graphics) {
		graphics.drawRect(100, 50, 100, 100);
		cageHasBeenPainted = true;
	}

	public boolean hasCageBeenPainted() {
		return cageHasBeenPainted;
	}

}
