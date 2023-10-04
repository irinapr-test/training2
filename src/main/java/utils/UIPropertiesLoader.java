package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UIPropertiesLoader {

    public static Properties properties = new Properties();
    private static final String CONFIG_FILE = "src/main/resources/ui.properties";
    private static final String MESSAGES_FILE = "src/main/resources/messages.properties";
    private static final String USERS_FILE = "src/main/resources/users.properties";

    public static Properties getConfiguration() {
        FileInputStream fp;
        try {
            fp = new FileInputStream(CONFIG_FILE);
            properties.load(fp);
            return properties;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Properties getAthProperties() {
        try {
            FileInputStream fp = new FileInputStream(USERS_FILE);
            Properties prop = new Properties();
            prop.load(fp);
            return prop;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Properties getValidationMessagesProperties() {
        try {
            FileInputStream fp = new FileInputStream(MESSAGES_FILE);
            Properties prop = new Properties();
            prop.load(fp);
            return prop;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getShopURL(){
        return getConfiguration().getProperty("SHOP_URL");
    }

    public static String getUserProperties(String propertyName) {
        return getAthProperties().getProperty(propertyName);
    }

    public static String getValidationMessage(String message) {
        return getValidationMessagesProperties().getProperty(message);
    }

}

