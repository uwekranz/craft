package userinterface;

import java.awt.Graphics;

public class FoodGraphic extends TypedJComponent {

	private Boolean hasBeenPainted = false;

	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawOval(500, 500, 25, 25);
		hasBeenPainted = true;
	}

	public Boolean hasBeenPainted() {
		return hasBeenPainted;
	}

}
