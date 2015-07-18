package model;

public enum Axis {
	HORIZONTAL_AXIS, VERTICAL_AXIS, NULL;

	public Axis getOrhogonalAxis() {
		switch (this) {
		case HORIZONTAL_AXIS:
			return VERTICAL_AXIS;
		case VERTICAL_AXIS:
			return HORIZONTAL_AXIS;
		default:
			return NULL;
		}
	}
}
