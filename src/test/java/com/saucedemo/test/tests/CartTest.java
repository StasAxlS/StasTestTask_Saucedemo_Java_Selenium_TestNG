package com.saucedemo.test.tests;

import com.saucedemo.test.base.BaseTest;
import com.saucedemo.test.pege.AuthorizationPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    String user = "standard_user";
    String pass = "secret_sauce";

    @Test(description = "TC-02 Add items to cart and verify content")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Shopping Cart")
    public void testAddItemsToCartAndVerify() {
        List<String> actualItemNames = new AuthorizationPage(getDriver())
                .enterUsername(user)
                .enterPassword(pass)
                .clickLoginButton()
                .clickAddCartLabsBackpackButton()
                .clickShoppingCart()
                .getItemNames();

        Assert.assertEquals(actualItemNames, List.of("Sauce Labs Backpack", "Sauce Labs Bike Light"));

    }
}
