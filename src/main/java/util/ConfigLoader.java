package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for loading configuration properties from a file.
 * Provides methods to retrieve property values by key.
 */
public class ConfigLoader {

    private static final String USER_CONFIG_FILE = "src/test/resources/config.properties";
    private Properties properties;

    /**
     * Initializes the ConfigLoader and loads properties from the configuration file.
     */
    public ConfigLoader() {
        this.properties = new Properties();
        loadProperties();
    }

    /**
     * Loads properties from the specified configuration file.
     * Throws a RuntimeException if the file cannot be loaded.
     */
    private void loadProperties() {
        try (FileInputStream file = new FileInputStream(USER_CONFIG_FILE)) {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties");
        }
    }

    /**
     * Retrieves the value of a property by its key.
     *
     * @param key the key of the property to retrieve
     * @return the value of the property, or null if the key does not exist
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}