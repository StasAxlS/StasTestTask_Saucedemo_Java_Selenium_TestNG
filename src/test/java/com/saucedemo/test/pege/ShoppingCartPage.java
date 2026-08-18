package com.saucedemo.test.pege;

import com.saucedemo.test.model.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    private List<WebElement> removeCartLabsBackpack;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemNames() {
        return removeCartLabsBackpack.stream().map(WebElement::getText).toList();
    }
}
