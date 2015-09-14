package model;

import java.awt.Dimension;

public class CageFactory {

	public static SnakeCage createSnakeCage() {
		return createSnakeCage(3000, 10000);
	}

	public static SnakeCage createSnakeCage(int height, int width) {
		SnakeCage snakeCage = new SnakeCage();
		Dimension cageDimensions = new Dimension(height, width);
		snakeCage.setDimensions(cageDimensions);

		return snakeCage;
	}

}
