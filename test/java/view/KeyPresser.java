package view;

import java.awt.AWTException;
import java.awt.Robot;

public class KeyPresser {

	private static Robot robot = tryToCreateKeyPressingRobot();

	public static void pressKeyWithCode(int keyCode) {
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);
		robot.delay(200);
	}

	private static Robot tryToCreateKeyPressingRobot() {
		try {
			return new Robot();
		} catch (AWTException exception) {
			throw new RuntimeException(exception);
		}
	}

}
