package com.sep.utilities;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * Reads the configuration properties from the Configuration.properties file.
 */
public class ConfigurationReader {

    /**
     * Returns the value of the specified property key from the Configuration.properties file.
     *
     * @param key the property key
     * @return the value of the specified property key
     */

    private static Properties properties;

    static {
        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getConfigProperty(String keyName) {
        return properties.getProperty(keyName);
    }


}
