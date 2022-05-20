package ru.makarovva.tests;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ElementsExistenceCheckTests {
    static  WebDriver driver;
    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        // изменять размеры окна - на максимум
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    @Test
    void checkoutPageElementsCheckTest() throws InterruptedException {

        // проверка URL

        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));

        //проверка элементов

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

    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}

