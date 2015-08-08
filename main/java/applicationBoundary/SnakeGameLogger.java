package applicationBoundary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SnakeGameLogger {
	public static void log(String message) {
		Logger logger = LogManager.getLogger();
		logger.info(message);
	}
}
