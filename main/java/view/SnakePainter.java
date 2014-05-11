package view;

import static model.Model.getSnakeLocation;

import java.awt.Graphics;
import java.awt.Point;

import model.Model;

public class SnakePainter {

	private boolean hasPainted = false;
	private boolean paintsRegularly = false;

	public void paint(Graphics graphics) {
		Point snakeLocation = getSnakeLocation();
		graphics.drawLine(snakeLocation.x, 100, snakeLocation.x + 100, 100);
		hasPainted = true;
	}

	public boolean hasPainted() {
		return hasPainted;
	}

	public boolean paintsRegularly() {
		return paintsRegularly;
	}

	public void paintRegularly(Graphics graphics) {
		paintEvery100Milliseconds(graphics);
		hasPainted = true;
	}

	private void paintEvery100Milliseconds(Graphics graphics) {
		SnakePaintingEverySecond snakePaintingEvery100Milliseconds = new SnakePaintingEverySecond(this, graphics);
		snakePaintingEvery100Milliseconds.start();
	}

	public void setPaintsRegularly(boolean paintsRegularly) {
		this.paintsRegularly = paintsRegularly;
	}

}
