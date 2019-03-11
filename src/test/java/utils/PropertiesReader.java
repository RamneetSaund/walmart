package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader(){
        BufferedReader reader;
        String path = System.getProperty("user.dir");
        String propertyFilePath = path + "\\src\\test\\resources\\test.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + propertyFilePath);
        }
    }

    public String getBaseUrl() {
        String url = properties.getProperty("baseUrl");
        if(url != null) return url;
        else throw new RuntimeException("baseUrl missing in properties file");
    }

    public int getElementTimeout() {
        String timeout = properties.getProperty("elementTimeout");
        if(timeout != null) return Integer.parseInt(timeout);
        else throw new RuntimeException("elementTimeout missing in properties file");
    }

    public String getBrowser() {
        String url = properties.getProperty("browser");
        if(url != null) return url;
        else throw new RuntimeException("browser missing in properties file");
    }
}
