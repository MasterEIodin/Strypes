package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyFileReader {

    public boolean readConfiguration() {
        String executionMode = System.getProperty("env", "test");

        String filePath = String.format("%s/%s.properties", System.getProperty("user.dir"), executionMode);
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println(String.format("Properties file %s does not exist!", file.getPath()));
            return false;
        }

        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        Properties propertiesFile = new Properties();
        try {
            propertiesFile.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        Enumeration propertyKeys = propertiesFile.keys();
        while (propertyKeys.hasMoreElements()) {
            String key = (String) propertyKeys.nextElement();
            String value = propertiesFile.getProperty(key);
            System.setProperty(key, value);
        }
        return true;
    }
}

