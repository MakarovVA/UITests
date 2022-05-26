package ru.makarovva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.makarovva.pages.BasePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPage extends BasePage {


    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "app_logo")
    private WebElement applicationLogo;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBy(className = "header_secondary_container")
    private WebElement headerSecondaryContainer;

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(className = "social_twitter")
    private WebElement twitterButton;

    @FindBy(className = "social_facebook")
    private WebElement facebookButton;

    @FindBy(className = "social_linkedin")
    private WebElement linkedinButton;

    @FindBy(className = "footer")
    private WebElement footer;

    @FindBy(className = "footer_robot")
    private WebElement robotImage;

    @FindBy(className = "footer_copy")
    private WebElement copyrightInfo;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement inventoryButton;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetButton;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement burgerCrossButton;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public CheckoutPage enterFirstName(String firstName) {
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterPostalCode(String postalCode) {
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    public FinishPage clickContinueButton() {
        continueButton.click();
        return new FinishPage(driver);
    }

    public CheckoutPage checkAllElementsExistence() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        assertThat(driver.findElements(By.className("app_logo")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("shopping_cart_link")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("header_secondary_container")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("title")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("first-name")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("last-name")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("postal-code")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("cancel")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("continue")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("social_twitter")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("social_facebook")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("social_linkedin")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("footer")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("footer_robot")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.className("footer_copy")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("react-burger-menu-btn")).size(), not(equalTo(0)));
        driver.findElement(By.id("react-burger-menu-btn")).click();
        assertThat(driver.findElements(By.id("inventory_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("about_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("logout_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("reset_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("react-burger-cross-btn")).size(), not(equalTo(0)));
        return this;
    }
}