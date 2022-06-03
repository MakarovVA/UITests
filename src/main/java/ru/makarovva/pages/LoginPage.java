package ru.makarovva.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-test='username']")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("Ввод логина")
    public LoginPage enterLogin(String loginName) {
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }
    @Step("Нажатие кнопки авторизаци")
    public InventoryPage clickLoginButton() {
        loginButton.click();
        return new InventoryPage(driver);
    }
}