package model;

public class Snake {

	private int length = 1;

	public void eat() {
		length += 1;
	}

	public int getLength() {
		return length;
	}

}
