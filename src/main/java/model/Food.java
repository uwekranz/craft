package model;

import java.awt.Dimension;

public class Food {

	Cage cage;
	Location location;
	private int size;

	public Food(Cage cage) {
		this.cage = cage;
		location = RandomLocation.createWithin(new Dimension(500, 500));
		size = 20;
	}

	public Food() {
		this.cage = new Cage();
		size = 20;
		location = RandomLocation.createWithin(new Dimension(500, 500));
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public int getSize() {
		return size;
	}

	public void decreaseSize() {
		this.size = size - 1;
	}

	public boolean isDigested() {
		return size == 0;
	}

	public void setSize(int size) {
		this.size = size;

	}

	public void renewLocation() {
		if (cage.getDimensions() != null) {
			location = RandomLocation.createWithin(cage.getDimensions());
		}
	}

}
