package controller;

import static java.awt.event.KeyEvent.VK_DOWN;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Direction;
import applicationBoundary.SnakeGameLogger;

public class ArrowKeysListener implements KeyListener {

	private Controller controller;

	public ArrowKeysListener(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		SnakeGameLogger.log("The key " + KeyEvent.getKeyText(keyEvent.getKeyCode()) + " has been pressed");
		if (keyEvent.getKeyCode() == VK_DOWN)
			controller.setDirectionOfSnakeMovement(Direction.DOWN);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
