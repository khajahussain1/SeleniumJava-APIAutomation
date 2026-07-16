package com.api.FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String CONFIH_FILE_PATH = "src/main/resources/config.properties";
    public static Properties properties;

    static {
        properties = new Properties();

            try {
                FileInputStream fis = new FileInputStream(CONFIH_FILE_PATH);
                properties.load(fis);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    public static String getBaseURl(){
        return properties.getProperty("BaseURL");
    }

    public static String gethosturl(){
        return getBaseURl()+properties.getProperty("HostURL");
    }

    public static String getBererToken(){
        return properties.getProperty("BearerToken");
    }

    public static String getEndPontURL(){
        return properties.getProperty("EndPontURL");
    }

}
