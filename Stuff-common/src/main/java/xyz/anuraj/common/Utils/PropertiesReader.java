package xyz.anuraj.common.Utils;

import xyz.anuraj.common.CustomExceptions.PropertyNotFoundException;

import java.awt.color.ProfileDataException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesReader {

    private final String fileName;
    private Properties properties;
    private final Class<?> initiatorClass;

    public PropertiesReader( Class<?> initiatorClass) {
        this.initiatorClass = initiatorClass;
        fileName = "application.properties";
        //loadPropertiesFile();
        try {
            properties = propertiesLoader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PropertiesReader(String pathToPropertiesFile, Class<?> initiatorClass) {
        this.initiatorClass = initiatorClass;
        fileName = pathToPropertiesFile;
        try {
            properties = propertiesLoader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Properties propertiesLoader() throws IOException {
        Properties configuration= new Properties();
//        InputStream inputStream = new FileInputStream(fileName);
        InputStream inputStream = initiatorClass.getClassLoader().getResourceAsStream(fileName);
        configuration.load(inputStream);
        Objects.requireNonNull(inputStream).close();
        return  configuration;
    }


    public String getProperty(String propertyName) throws PropertyNotFoundException {
        String result =properties.getProperty(propertyName);
        if(result != null) {
            return result;
        } else {
            throw new PropertyNotFoundException(propertyName);
        }
    }
}
