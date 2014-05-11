package model;

import java.awt.Point;

public class Model {
	
	private static Snake snake = null;

	public static Point getSnakeLocation() {
		if(snake == null)
			snake = new Snake().whichIsMoving();
		return snake.getLocation();
		
	}
	
	
	
}