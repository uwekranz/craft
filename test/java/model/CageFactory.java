package model;
import java.awt.Dimension;

import model.SnakeCage;


public class CageFactory {

	public static SnakeCage createSnakeCage() {
		SnakeCage snakeCage = new SnakeCage();
		Dimension cageDimensions = new Dimension(3000, 10000);
		snakeCage.setDimensions(cageDimensions);
		return snakeCage;
	}

}
