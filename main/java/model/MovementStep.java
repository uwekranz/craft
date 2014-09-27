package model;

public class MovementStep {

	private int stepDistance;
	private Direction direction;
	private Location location;

	public MovementStep(int stepDistance) {
		this.stepDistance = stepDistance;
	}

	protected MovementStep from(Location location) {
		this.location = location;
		return this;
	}

	protected void inDirection(Direction direction) {
		this.direction = direction;
	}
}
