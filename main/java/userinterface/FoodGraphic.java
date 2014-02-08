package userinterface;

import java.awt.Graphics;

public class FoodGraphic extends TypedJComponent {

	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawOval(500, 500, 25, 25);
	}

}
