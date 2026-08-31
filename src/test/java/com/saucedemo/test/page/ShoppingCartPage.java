package com.saucedemo.test.page;

import com.saucedemo.test.model.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryItemName;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemNames() {
        return inventoryItemName.stream().map(WebElement::getText).toList();
    }
}
