package com.saucedemo.test.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends BaseModel {

    protected BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage refresh() {
        getDriver().navigate().refresh();
        waitUntilPageLoad();
        return this;
    }

    protected void waitUntilPageLoad() {
        new org.openqa.selenium.support.ui.WebDriverWait(getDriver(), java.time.Duration.ofSeconds(10))
                .until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }
}
