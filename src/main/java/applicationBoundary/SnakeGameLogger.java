package applicationBoundary;

import org.apache.logging.log4j.LogManager;

public class SnakeGameLogger {

	public static void debug(Object classToLogFrom, String message) {
		LogManager.getLogger(classToLogFrom.toString()  + classToLogFrom).debug(message);
		System.out.println(message);
	}

	public static void info(Object classToLogFrom, String message) {
		LogManager.getLogger(classToLogFrom).info(message);
		System.out.println(classToLogFrom.toString() + message);
	}
}
