package model;

import java.awt.Point;

public class Location {

	private Point coordinates;

	public Location(Point point) {
		this.coordinates = point;
	}

	@Override
	public String toString() {
		return "(" + coordinates.x + "," + coordinates.y + ")";
	}

	public int getCoordinate(Axis axis) {
		if (axis.equals(Axis.HORIZONTAL))
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
