package controller;

import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import static model.Direction.DOWN;
import static model.Direction.LEFT;
import static model.Direction.RIGHT;
import static model.Direction.UP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import applicationBoundary.SnakeGameLogger;

public class ArrowKeysListener implements KeyListener {

	private Controller controller;

	public ArrowKeysListener(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		String message = "The key " + KeyEvent.getKeyText(keyEvent.getKeyCode()) + " has been pressed";
		SnakeGameLogger.info(this, message);

		if (keyEvent.getKeyCode() == VK_DOWN)
			controller.setDirectionOfSnakeMovement(DOWN);
		if (keyEvent.getKeyCode() == VK_UP)
			controller.setDirectionOfSnakeMovement(UP);
		if (keyEvent.getKeyCode() == VK_RIGHT)
			controller.setDirectionOfSnakeMovement(RIGHT);
		if (keyEvent.getKeyCode() == VK_LEFT)
			controller.setDirectionOfSnakeMovement(LEFT);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
