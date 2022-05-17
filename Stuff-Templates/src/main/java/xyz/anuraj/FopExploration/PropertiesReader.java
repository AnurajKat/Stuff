package xyz.anuraj.FopExploration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    static String fileName;
    static Properties properties;
    static InputStream inputStream;

    public PropertiesReader() {
        fileName = "Stuff-Templates\\src\\main\\resources\\fapp.properties";
        loadPropertiesFile();
    }

    private static void loadPropertiesFile() {
        try {
            inputStream = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Target(ElementType.FIELD)
//    @Retention(RetentionPolicy.RUNTIME)
//    public @interface PropertyValue {
//
//    }




    public String getProperty(String propertyName) {

        return properties.getProperty(propertyName);

//        try (InputStream input = new FileInputStream(fileName)) {
//            Properties properties = new Properties();
//            properties.load(input);
//            return properties.getProperty(propertyName);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
