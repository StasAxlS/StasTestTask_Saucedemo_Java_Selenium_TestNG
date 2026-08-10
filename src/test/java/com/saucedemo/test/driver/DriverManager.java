package com.saucedemo.test.driver;

import com.saucedemo.test.utils.ConfigReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("Драйвер не инициализирован. Убедитесь, что @BeforeMethod setUp() был вызван.");
        }
        return driver;
    }

    public static void setUp(String browser) {
        Objects.requireNonNull(browser, "browser не задан");
        WebDriver driver = DriverFactory.createDriver(browser);
        configureWindow(driver);
        DRIVER.set(driver);
    }

    public static void quit() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
        }
        DRIVER.remove();
    }

    private static void configureWindow(WebDriver driver) {
        String size = ConfigReader.get("window.size");
        if (size == null || size.equalsIgnoreCase("maximize")) {
            driver.manage().window().maximize();
        } else if (size.contains("x")) {
            String[] dims = size.toLowerCase().split("x");
            int w = Integer.parseInt(dims[0].trim());
            int h = Integer.parseInt(dims[1].trim());
            driver.manage().window().setSize(new Dimension(w, h));
        }
    }
}
