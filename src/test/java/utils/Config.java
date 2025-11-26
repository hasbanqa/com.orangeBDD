package utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config {

    private static final Logger logger = LogManager.getLogger(Config.class);
    private static final Properties props = new Properties();

    static {
        String env = System.getProperty("env", "qa").toLowerCase();
        String path = "/config/" + env + ".properties";

        logger.info("Loading config for environment: {}", env);

        try (InputStream input = Config.class.getResourceAsStream(path)) {
            if (input == null) {
                logger.error("Config file not found at path: {}", path);
                throw new RuntimeException("Could not find config file: " + path);
            }
            props.load(input);
            logger.info("Config file {} loaded successfully.", path);
        } catch (IOException e) {
            logger.error("Failed to load config file: {}", path, e);
            throw new RuntimeException("Failed to load config file: " + path, e);
        }
    }

    public static String getProperty(String key) {
        String value = props.getProperty(key);
        logger.debug("Reading property '{}' = '{}'", key, value);
        return value;
    }

    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }
}
