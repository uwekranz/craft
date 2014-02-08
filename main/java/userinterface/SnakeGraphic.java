package userinterface;

import java.awt.Graphics;

public class SnakeGraphic extends TypedJComponent {

	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawLine(1000, 100, 100, 100);
	}

}
