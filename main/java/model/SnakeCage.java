package model;

import java.awt.Dimension;

public class SnakeCage {

	private Dimension dimensions;

	public SnakeCage() {
	}

	public SnakeCage(Dimension dimensions) {
		this.dimensions = dimensions;
	}

	public void setDimensions(Dimension snakeCageViewDimensions) {
		dimensions = snakeCageViewDimensions;
	}

	public Dimension getDimensions() {
		return dimensions;
	}

}
