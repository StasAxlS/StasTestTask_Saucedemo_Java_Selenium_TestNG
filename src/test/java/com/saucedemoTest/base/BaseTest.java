package com.saucedemoTest.base;

import com.saucedemoTest.driver.DriverManager;
import com.saucedemoTest.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
