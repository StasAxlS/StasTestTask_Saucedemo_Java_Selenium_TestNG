package com.saucedemo.test.base;

import com.saucedemo.test.driver.DriverManager;
import com.saucedemo.test.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.get("browser");
        if (browser == null) browser = "chrome";

        log.info("Запуск теста в браузере: {}", browser);
        DriverManager.setUp(browser);

        String baseUrl = ConfigReader.get("base.url");
        if (baseUrl == null) {
            throw new IllegalStateException("base.url не задан в config.properties");
        }
        String url = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        log.info("Открытие URL: {}", url);
        getDriver().get(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }

}
