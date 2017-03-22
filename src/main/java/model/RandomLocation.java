package model;

import java.awt.Dimension;
import java.util.Random;

public class RandomLocation {

	static Location createWithin(Dimension cageDimensions) {
		int width = new Random().nextInt((int) cageDimensions.getWidth());
		int height = new Random().nextInt((int) cageDimensions.getHeight());
		return new Location(width, height);
	}

}
