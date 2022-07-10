package ru.makarovva.pages;

import io.qameta.allure.Step;
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
    @Step ("Нажатие кнопки Checkout")
    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage(driver);


    }
}