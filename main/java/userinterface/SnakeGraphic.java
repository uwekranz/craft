package userinterface;

import java.awt.Graphics;

public class SnakeGraphic extends TypedJComponent {

	private Boolean hasBeenPainted = false;

	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawLine(1000, 100, 100, 100);
		hasBeenPainted = true;
	}

	public Boolean hasBeenPainted() {
		// TODO Auto-generated method stub
		return hasBeenPainted;
	}

}
