package com.saucedemo.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Logger log = LoggerFactory.getLogger(ConfigReader.class) ;
    private static final Properties properties = new Properties();

    static {
        // Файл ищется в classpath, а не на диске — работает из любой директории
        try (InputStream is = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is == null) {
                log.warn("config.properties не найден в classpath. "
                        + "Будут использованы значения по умолчанию / -D аргументы.");
            } else {
                properties.load(is);
            }
        } catch (Exception e) {
            log.error("Не удалось прочитать config.properties", e);
        }
    }

    private ConfigReader() {}

    /**
     * Приоритет: 1) -D аргумент JVM → 2) config.properties → 3) null
     */
    public static String get(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            value = properties.getProperty(key);
        }
        return value;
    }

    /** Удобная обёртка для boolean */
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

}
