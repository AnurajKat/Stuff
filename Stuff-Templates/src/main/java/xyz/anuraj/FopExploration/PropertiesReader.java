package xyz.anuraj.FopExploration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesReader {

    private final String fileName;
    private Properties properties;

    public PropertiesReader() {
        fileName = "Stuff-Templates\\src\\main\\resources\\fapp.properties";
        //loadPropertiesFile();
        try {
            properties = propertiesLoader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PropertiesReader(String pathToPropertiesFile) {
        fileName = pathToPropertiesFile;
        try {
            properties = propertiesLoader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Properties propertiesLoader() throws IOException {
        Properties configuration= new Properties();
        InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(fileName);
        configuration.load(inputStream);
        Objects.requireNonNull(inputStream).close();
        return  configuration;
    }


    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
