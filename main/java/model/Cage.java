package model;

import java.awt.Dimension;

public class Cage {

	private Dimension dimensions;

	public Cage() {
	}

	public Cage(Dimension dimensions) {
		this.dimensions = dimensions;
	}

	public void setDimensions(Dimension snakeCageViewDimensions) {
		dimensions = snakeCageViewDimensions;
	}

	public Dimension getDimensions() {
		return dimensions;
	}

}
