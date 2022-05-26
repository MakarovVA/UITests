package ru.makarovva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class InventoryPage extends BasePage {
    @FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartSauceLabsBackpackButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public InventoryPage addToCart() {
        addToCartSauceLabsBackpackButton.click();
        return this;
    }
    
    public ShoppingCartPage clickShoppingCartButton() {
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }

}