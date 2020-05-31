package applicationBoundary;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;

public class SnakeGameLogger {

	public SnakeGameLogger() {
		Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.DEBUG);
	}

	public static void debug(Object classToLogFrom, String message) {
		LogManager.getLogger(classToLogFrom.toString()  + classToLogFrom).debug(message);
		System.out.println(message);
	}

	public static void info(Object classToLogFrom, String message) {
		LogManager.getLogger(classToLogFrom).info(message);
		System.out.println(classToLogFrom.toString() + message);
	}
}
