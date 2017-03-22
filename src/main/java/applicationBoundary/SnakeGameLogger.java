package applicationBoundary;

import org.apache.logging.log4j.LogManager;

public class SnakeGameLogger {

	public static void debug(Object classToLogFrom, String message) {
		LogManager.getLogger(classToLogFrom).debug(message);
	}

	public static void info(Object classToLogFrom, String message) {
		LogManager.getLogger(classToLogFrom).info(message);
	}
}
