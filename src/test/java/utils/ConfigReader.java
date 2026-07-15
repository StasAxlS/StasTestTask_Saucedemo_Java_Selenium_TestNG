package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Предупреждение: Файл config.properties не найден! Будут использованы дефолтные значения.");
        }
    }

    /**
     * Универсальный метод для получения любого свойства по ключу
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

}
