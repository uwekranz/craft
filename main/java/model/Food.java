package model;

import java.awt.Dimension;

public class Food {

	Dimension cageDimensions;
	Location location;

	public Food(Dimension cageDimensions) {
		this.cageDimensions = cageDimensions;
		location = RandomLocation.createWithin(cageDimensions);
	}

	public Food() {
		location = RandomLocation.createWithin(new Dimension(500, 500));
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public int getSize() {
		return 20;
	}

}
