package utils;

import java.util.Properties;

public class ConfigLoader {

    private static ConfigLoader configLoader;
    private final Properties properties; //making it final so that once loaded it can never be changed

    //make constructor private to achieve singleton design pattern
    private ConfigLoader() {
        properties = PropertyUtils.loadProperties("./src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            //initialize only once when its null
            configLoader = new ConfigLoader();
        }
        //return the initialized one only which was initialized when it was null
        return configLoader;
    }

    public String getUrl() {
        String prop = properties.getProperty("url");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property url is not specified in config.properties file");
        }
    }
}
