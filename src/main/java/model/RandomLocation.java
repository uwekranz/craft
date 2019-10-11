package model;

import java.awt.*;
import java.util.Random;

public class RandomLocation {

	static Location createWithin(Cage cage) {
		Dimension dimensions = cage.getDimensions();
		int width = new Random().nextInt((int) dimensions.getWidth());
		int height = new Random().nextInt((int) dimensions.getHeight());
		return new Location(width, height);
	}

}
