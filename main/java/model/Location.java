package model;

import java.awt.Point;

public class Location {

	private Point coordinates;

	public Location(Point point) {
		this.coordinates = point;
	}

	public int getHorizontalCoordinate() {
		return coordinates.x;
	}

	public int getVerticalCoordinate() {
		return coordinates.y;
	}

	public void move(int horizontalCoordinate, int verticalCoordinate) {
		coordinates.move(horizontalCoordinate, verticalCoordinate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinates == null) ? 0 : coordinates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		return true;
	}

}
