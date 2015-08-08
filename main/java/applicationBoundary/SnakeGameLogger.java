package applicationBoundary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SnakeGameLogger {
	private static Logger logger = LogManager.getLogger();

	public static void debug(String message) {
		logger.debug(message);
	}

	public static void info(String message) {
		logger.info(message);
	}
}
