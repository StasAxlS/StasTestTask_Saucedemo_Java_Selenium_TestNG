package com.saucedemo.test.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.saucedemoTest.utils.DriverManager;


public abstract class BasePage {
    protected WebDriverWait wait;

    protected WebDriver getDriver() {
        return DriverManager;
    }
}
