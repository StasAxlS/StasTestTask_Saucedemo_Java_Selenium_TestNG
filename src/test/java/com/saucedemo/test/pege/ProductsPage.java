package com.saucedemo.test.pege;

import com.saucedemo.test.model.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addCartLabsBackpack;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeCartLabsBackpack;

    @FindBy(className = "product_sort_container")
    private WebElement productSortDropdown;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public ProductsPage clickAddCartLabsBackpackButton() {
        addCartLabsBackpack.click();
        return this;
    }

    public ProductsPage clickRemoveCartLabsBackpackButton() {
        removeCartLabsBackpack.click();
        return this;
    }

    public ProductsPage sortProductsPriceLowToHigh() {
        Select dropdown = new Select(productSortDropdown);;
        dropdown.selectByVisibleText("Price (low to high)");

        return this;
    }


    public ShoppingCartPage clickShoppingCart() {
        shoppingCart.click();
        return new ShoppingCartPage(getDriver());
    }

}
