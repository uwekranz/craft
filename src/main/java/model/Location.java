package model;

import java.awt.Point;

public class Location {

	private Point coordinates;

	public Location(int horizontalCoordinate, int verticalCoordinate) {
		this.coordinates = new Point(horizontalCoordinate, verticalCoordinate);
	}

	public Location() {
		this.coordinates = new Point(0, 0);
	}

	@Override
	public String toString() {
		return "(" + coordinates.x + "," + coordinates.y + ")";
	}

	public int getCoordinate(Axis axis) {
		if (axis.equals(Axis.HORIZONTAL_AXIS))
			return coordinates.x;
		return coordinates.y;
	}

	public void setCoordinates(int horizontalCoordinate, int verticalCoordinate) {
		coordinates.move(horizontalCoordinate, verticalCoordinate);
	}

	@Override
	public int hashCode() {
		return coordinates.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		Location other = (Location) object;
		if (coordinates == null) {
			if (other.coordinates != null)
				return false;
		} else if (!coordinates.equals(other.coordinates))
			return false;
		return true;
	}

}
