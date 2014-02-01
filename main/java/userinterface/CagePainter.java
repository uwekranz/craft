package userinterface;

import java.awt.Graphics;

public class CagePainter {

	private static boolean cageHasBeenPainted = false;

	public static void paint(Graphics graphics) {
		graphics.drawRect(100, 50, 100, 100);
		cageHasBeenPainted = true;
	}

	public static boolean hasCageBeenPainted() {
		return cageHasBeenPainted;
	}

}
