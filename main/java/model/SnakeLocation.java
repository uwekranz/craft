package model;

import static model.Axis.HORIZONTAL_AXIS;
import static model.Axis.VERTICAL_AXIS;

import java.util.ArrayList;
import java.util.List;

public class SnakeLocation {

	private List<Location> location;

	public SnakeLocation() {
		location = new ArrayList<Location>();
		location.add(new Location(0, 0));
	}

	public int getCoordinate(Axis axis) {
		return location.get(0).getCoordinate(axis);
	}

	public void setCoordinates(int horizontalCoordinate, int verticalCoordinate) {
		location.get(0)
				.setCoordinates(horizontalCoordinate, verticalCoordinate);
	}

	public void add(int stepDistance, Axis coordinateAxis) {
		int newValue = getCoordinate(coordinateAxis) + stepDistance;
		if (coordinateAxis.equals(VERTICAL_AXIS))
			setCoordinates(getCoordinate(HORIZONTAL_AXIS), newValue);
		else
			setCoordinates(newValue, getCoordinate(VERTICAL_AXIS));
	}

	@Override
	public int hashCode() {
		return ((location == null) ? 0 : location.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SnakeLocation other = (SnakeLocation) obj;
		if (!location.equals(other.location))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return location.toString();
	}

}
