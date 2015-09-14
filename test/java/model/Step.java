package model;

public class Step {
	SnakeMovement movement;

	public Step(SnakeMovement movement) {
		this.movement = movement;
	}

	public void step(Direction direction) {
		movement.setDirection(direction);
		movement.updateSnakeLocation();
	}
}
