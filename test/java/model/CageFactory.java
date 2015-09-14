package model;

import java.awt.Dimension;

public class CageFactory {

	public static Cage createSnakeCage() {
		return createSnakeCage(3000, 10000);
	}

	public static Cage createSnakeCage(int height, int width) {
		Cage snakeCage = new Cage();
		Dimension cageDimensions = new Dimension(height, width);
		snakeCage.setDimensions(cageDimensions);

		return snakeCage;
	}

}
