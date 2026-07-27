package com.saucedemoTest.driver;

import com.saucedemoTest.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver createDriver(String browserName) {
        boolean headless = ConfigReader.getBoolean("headless");

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
