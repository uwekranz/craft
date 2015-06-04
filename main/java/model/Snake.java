package model;

public class Snake {

	public static final int INITIAL_BODY_LENGTH = 100;

	private int bodyLength = INITIAL_BODY_LENGTH;
	SnakeLocation location = new SnakeLocation(bodyLength);
	private SnakeMovement movement = new SnakeMovement(this);

	public Snake whichIsMoving() {
		beginToMove();
		return this;
	}

	public void eat() {
		bodyLength += 1;
	}

	public void move(Direction direction, int stepDistance) {
		location.updateAccordingToMovement(direction, stepDistance);
	}

	public void beginToMove() {
		System.out.println("The snake begins to move");
		movement.start();
	}

	public int getBodyLength() {
		return bodyLength;
	}

	public SnakeLocation getLocation() {
		return location;
	}

	public int getCoordinateOf(BodyPart bodyPart, Axis axis) {
		return location.getCoordinate(bodyPart, axis);
	}

	public void setDirectionOfMovement(Direction direction) {
		movement.setDirection(direction);
	}

	public int getStepDistanceOfMovement() {
		return movement.STEP_DISTANCE;
	}
}
