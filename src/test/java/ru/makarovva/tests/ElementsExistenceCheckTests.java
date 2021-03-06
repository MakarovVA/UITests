package ru.makarovva.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.makarovva.pages.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ElementsExistenceCheckTests extends BaseTest {


    @Story("Проверка наличия всех элементов на странице Checkout")
    @Description("Проверка наличия всех элементов на странице Checkout")
    @Test
    void checkoutPageElementsCheckTest() throws InterruptedException {

        new LoginPage(driver)
                .enterLogin(username1)
                .enterPassword(password)
                .clickLoginButton()
                .addToCart()
                .clickShoppingCartButton()
                .clickCheckoutButton()
                .checkAllElementsExistence();

    }
}
