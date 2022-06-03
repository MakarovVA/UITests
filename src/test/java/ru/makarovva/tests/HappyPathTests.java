package ru.makarovva.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
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

class HappyPathTests extends BaseTest {

    @Story("Happy Path тест")
    @Feature("Проверка полного пути покупки товара")
    @Description("Happy Path тест")
    @Test
    void authorisationPositiveTest() throws InterruptedException {

        new LoginPage(driver)
                .enterLogin(username1)
                .enterPassword(password)
                .clickLoginButton()
                .addToCart()
                .clickShoppingCartButton()
                .clickCheckoutButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterPostalCode(postalCode)
                .clickContinueButton()
                .clickFinishButton()
                .checkCompletePageUrl()
                .checkImageOnThePage();

    }

}
