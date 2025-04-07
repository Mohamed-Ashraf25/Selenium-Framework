package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtils {


    public static final String LOGS_PATH = "test-output/logs/";
    private LogsUtils() {
        super();    // Private constructor to prevent instantiation
    }
    public static Logger loggers() {
        return  LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());

    }
    public static void Trace(String... message) {
        loggers().trace(String.join("", message));

    }
    public static void Debug(String... message) {
        loggers().debug(String.join("", message));

    }
    public static void Info(String... message) {
        loggers().info(String.join("", message));

    }
    public static void Warn(String... message) {
        loggers().warn(String.join("", message));

    }
    public static void Error(String... message) {
        loggers().error(String.join("", message));

    }


}
