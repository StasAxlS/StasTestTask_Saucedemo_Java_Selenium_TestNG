package com.saucedemoTest.base;

import com.saucedemoTest.driver.DriverManager;
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
import com.saucedemoTest.utils.ConfigReader;

public abstract class BaseTest {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.get("browser");
        if (browser == null) browser = "chrome";
        DriverManager.setUp(browser);

        String baseUrl = ConfigReader.get("base.url");
        if (baseUrl == null) {
            throw new IllegalStateException("base.url не задан в config.properties");
        }
        getDriver().get(baseUrl.endsWith("/") ? baseUrl : baseUrl + "/");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }

}
