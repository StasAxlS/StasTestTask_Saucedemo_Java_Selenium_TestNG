package com.saucedemo.test.driver;

import com.saucedemo.test.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DriverFactory {
    private DriverFactory() {
    }

    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver createDriver(String browserName) {
        boolean headless = ConfigReader.getBoolean("headless");
        log.info("Создаю драйвер: browser={}, headless={}", browserName, headless);

        return switch (browserName.toLowerCase()) {
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) options.addArguments("-headless");
                yield new FirefoxDriver(options);
            }
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                if (headless) options.addArguments("--headless=new");
                yield new EdgeDriver(options);
            }
            default -> {
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                yield new ChromeDriver(options);
            }
        };
    }
}
