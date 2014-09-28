package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Direction;
import applicationBoundary.SnakeGameLogger;

public class DownKeyListener implements KeyListener {

	private Controller controller;

	public DownKeyListener(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		SnakeGameLogger.log("The key " + KeyEvent.getKeyText(keyEvent.getKeyCode()) + " has been pressed");
		controller.setDirectionOfSnakeMovement(Direction.DOWN);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
