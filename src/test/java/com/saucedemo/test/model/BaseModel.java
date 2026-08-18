package com.saucedemo.test.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BaseModel {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BaseModel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected WebDriverWait getCustomWait(int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
    }
}
