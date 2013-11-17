package model;
public class Snake {

	private int length;

	public void eat(SnakeFood unitOfFood) {
		length += 1;
	}

	public int getLength() {
		return length;
	}

}
