package ru.makarovva.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.openqa.selenium.support.PageFactory.initElements;

public class InventoryPage extends BasePage {
    @FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartSauceLabsBackpackButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBy(css = "[value = 'az' ]")
    public WebElement sorterAZ;
    @FindBy(css = "[value = 'za' ]")
    public WebElement sorterZA;
    @FindBy(css = "[value = 'lohi' ]")
    public WebElement sorterLOHI;
    @FindBy(css = "[value = 'hilo' ]")
    public WebElement sorterHILO;
    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton = null;

    public InventoryPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }
    @Step("Добавление товара в корзину")
    public InventoryPage addToCart() {
        addToCartSauceLabsBackpackButton.click();
        return this;
    }
    @Step("Нажатие на кнопку корзины")
    public ShoppingCartPage clickShoppingCartButton() {
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }

    List<String> sorter1 = new ArrayList<>();
    List<String> sorter2 = new ArrayList<>();
    List<String> sorter3 = new ArrayList<>();
    List<String> sorter4 = new ArrayList<>();

    @Step("Сортировка по алфавиту")
    public InventoryPage sorterAtoZ() {
        sorterAZ.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[class='inventory_item_name']"));

        for (WebElement element : elements) {
            String text = element.getText();
            sorter1.add(text);
        }
        return this;
    }
    @Step("Сортировка с конца алфавита")
    public InventoryPage sorterZtoA() {
        sorterZA.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[class='inventory_item_name']"));

        for (WebElement element : elements) {
            String text = element.getText();
            sorter2.add(text);
        }
        return this;
    }
    @Step("Сортировка от дешёвого к дорогому")
    public InventoryPage sorterLowToHigh() {
        sorterLOHI.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[class='inventory_item_name']"));

        for (WebElement element : elements) {
            String text = element.getText();
            sorter3.add(text);
        }
        return this;
    }
    @Step("Сортировка от дорогого к дешёвому")
    public InventoryPage sorterHighToLow() {
        sorterHILO.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[class='inventory_item_name']"));

        for (WebElement element : elements) {
            String text = element.getText();
            sorter4.add(text);
        }
        return this;
    }
    @Step("Сравнение сортировки")
    public InventoryPage compareSorting() {
        List<String> sort1 = sorter1;
        List<String> sort2 = sorter2;
        List<String> sort3 = sorter3;
        List<String> sort4 = sorter4;

        assertThat(sort2.stream().sorted().collect(Collectors.toList()), equalTo(sort1));
        assertThat(sort3.stream().sorted().collect(Collectors.toList()), equalTo(sort1));
        assertThat(sort4.stream().sorted().collect(Collectors.toList()), equalTo(sort1));
        return this;
    }
    @Step("Переход на сайт LinkedIn")
    public void goToLinkedIn() {
        linkedInButton.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));


    }
    @Step ("Проверка URL")
    public InventoryPage checkInventoryPageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }
}

