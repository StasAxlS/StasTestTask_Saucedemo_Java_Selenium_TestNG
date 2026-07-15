package com.saucedemoTest.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public abstract class BaseTest {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    private WebDriver createDriverInstance(String browserName) {
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.get("headless"));

        return switch (browserName.toLowerCase()) {
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (isHeadless) options.addArguments("-headless");
                yield new FirefoxDriver(options);
            }
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                if (isHeadless) options.addArguments("--headless=new");
                yield new EdgeDriver(options);
            }
            default -> {
                ChromeOptions options = new ChromeOptions();
                if (isHeadless) options.addArguments("--headless=new");
                yield new ChromeDriver(options);
            }
        };
    }

    private void closeDriverInstance(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    private void configureWindowSize(WebDriver driver) {
        String sizeSetting = ConfigReader.get("window.size");

        if (sizeSetting == null || sizeSetting.equalsIgnoreCase("maximize")) {
            driver.manage().window().maximize();
        } else if (sizeSetting.contains("x")) {
            String[] dimensions = sizeSetting.toLowerCase().split("x");
            int width = Integer.parseInt(dimensions[0].trim());
            int height = Integer.parseInt(dimensions[1].trim());
            driver.manage().window().setSize(new Dimension(width, height));
        }
    }

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser");

        if (browser == null) {
            browser = ConfigReader.get("browser");
        }

        if (browser == null) {
            browser = "chrome";
        }

        WebDriver driver = createDriverInstance(browser);
        configureWindowSize(driver);
        driverThreadLocal.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = driverThreadLocal.get();
        try {
            closeDriverInstance(driver);
        } finally {
            driverThreadLocal.remove();
        }
    }

}
