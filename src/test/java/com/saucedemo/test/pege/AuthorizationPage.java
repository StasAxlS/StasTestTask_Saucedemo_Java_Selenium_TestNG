package com.saucedemo.test.pege;

import com.saucedemo.test.model.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public AuthorizationPage enterUsername(String username) {
        getCustomWait(2).until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys(username);
        return this;
    }

    public AuthorizationPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

}
