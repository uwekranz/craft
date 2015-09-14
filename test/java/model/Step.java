package model;

public class Step {
	Movement movement;

	public Step(Movement movement) {
		this.movement = movement;
	}

	public void step(Direction direction) {
		movement.setDirection(direction);
		movement.updateSnakeLocation();
	}
}
