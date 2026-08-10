package com.saucedemo.test.model;

import com.saucedemo.test.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BaseModel {

    protected final WebDriverWait wait;

    public BaseModel() {
        this.wait = new WebDriverWait(DriverManager.getDriver(), java.time.Duration.ofSeconds(10));
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected WebDriverWait getCustomWait(int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
    }
}
