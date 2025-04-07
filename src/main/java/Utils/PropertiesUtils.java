package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class PropertiesUtils {

    private PropertiesUtils() {
        super();    // Private constructor to prevent instantiation
    }

    public final static String Properties_Path = "src/main/resources";

    public static Properties loadProperties() {
        try {

            Properties properties = new Properties();
            Collection<File> propertiesfilelist =
                    FileUtils.ListFiles(new File(Properties_Path), new String[]{"properties"}, true);
            propertiesfilelist.forEach(propertyfile -> {
                try {
                    properties.load(new FileInputStream(propertyfile));
                } catch (Exception ioe) {
                    LogsUtils.Error("Error loading properties file:" + ioe.getMessage());
                }
                properties.putAll(System.getProperties());
                System.getProperties().putAll(properties);

            });


            LogsUtils.Info("Properties loaded successfully from: ", propertiesfilelist.toString());

            return properties;
        } catch (Exception e) {
            LogsUtils.Error("Error loading properties file: ", e.getMessage());
            return null;
        }
    }



    public static String getProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogsUtils.Error("Error retrieving property: ", e.getMessage());
            return "";
        }
    }}

//    public static void setProperty(String key, String value) {
//        try {
//            System.setProperty(key, value);
//        } catch (Exception e) {
//            LogsUtils.Error("Error setting property: ", key, " - ", e.getMessage());
//        }
//    }


