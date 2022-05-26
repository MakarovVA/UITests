package ru.makarovva.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = "[data-test='checkout']")
    private WebElement checkoutButton;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage(driver);


    }
}