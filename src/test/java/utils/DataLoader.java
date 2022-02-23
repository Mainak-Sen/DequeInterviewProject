package utils;

import java.util.Properties;

public class DataLoader {

    private static DataLoader dataLoader;
    private final Properties properties; //making it final so that once loaded it can never be changed

    //make constructor private to achieve singleton design pattern
    private DataLoader() {
        properties = PropertyUtils.loadProperties("./src/test/resources/data.properties");
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            //initialize only once when its null
            dataLoader = new DataLoader();
        }
        //return the initialized one only which was initialized when it was null
        return dataLoader;
    }

    public String getFirstVideoText() {
        String prop = properties.getProperty("firstVideoText");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property firstVideoText is not specified in data.properties file");
        }
    }

    public String getUpdatedVideoText() {
        String prop = properties.getProperty("updatedVideoText");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property updatedVideoText is not specified in data.properties file");
        }
    }

    public int getexpectedRadioButtonCountUnderLetTheAdventureBegin() {
        String prop = properties.getProperty("expectedRadioButtonCountUnderLetTheAdventureBegin");
        if (prop != null) {
            return Integer.parseInt(prop);
        } else {
            throw new RuntimeException("Property updatedVideoText is not specified in data.properties file");
        }
    }
}
