package com.saucedemo.test.model;

import com.saucedemo.test.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    protected final WebDriverWait wait;

    public BasePage() {
        this.wait = new WebDriverWait(DriverManager.getDriver(), java.time.Duration.ofSeconds(10));
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
