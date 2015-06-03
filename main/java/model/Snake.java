package model;

public class Snake {

	public static final int INITIAL_BODY_LENGTH = 100;
	static final int STEP_DISTANCE = 10;

	private int bodyLength = INITIAL_BODY_LENGTH;
	SnakeLocation location = new SnakeLocation(bodyLength);
	private Direction directionOfMovement = Direction.RIGHT;

	public Snake whichIsMoving() {
		beginToMove();
		return this;
	}

	public void eat() {
		bodyLength += 1;
	}

	public void move() {
		location.updateAccordingTo(directionOfMovement);
	}

	public void beginToMove() {
		System.out.println("The snake begins to move");
		Thread thread = new SnakeMovement(this);
		thread.start();
	}

	public void setDirectionOfMovement(Direction direction) {
		this.directionOfMovement = direction;
	}

	public int getBodyLength() {
		return bodyLength;
	}

	public SnakeLocation getLocation() {
		return location;
	}

	public Direction getDirectionOfMovement() {
		return directionOfMovement;
	}

	public int getCoordinateOf(BodyPart bodyPart, Axis axis) {
		return location.getCoordinate(bodyPart, axis);
	}
}
