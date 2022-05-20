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

class HappyPathTests {
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
    }

    @Test
    void authorisationPositiveTest() throws InterruptedException {
        // ввести логин
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // ввести пароль
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        // нажать на кнопку Login
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        //добавляем покупку
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        //заходим в корзину
        driver.findElement(By.className("shopping_cart_link")).click();
        //переходим к оформлению заказа
        driver.findElement(By.cssSelector("[data-test='checkout']")).click();
        //вводим данные
        driver.findElement(By.id("first-name")).click();
        driver.findElement(By.id("first-name")).sendKeys("Vladimir");
        driver.findElement(By.id("last-name")).click();
        driver.findElement(By.id("last-name")).sendKeys("Makarov");
        driver.findElement(By.id("postal-code")).click();
        driver.findElement(By.id("postal-code")).sendKeys("620144");
        //жмём продолжить
        driver.findElement(By.id("continue")).click();
        //жмём закончить
        driver.findElement(By.id("finish")).click();


        Thread.sleep(3000);



        // проверки
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        // проверить наличие элемента
        assertThat(driver.findElements(By.className("pony_express")).size(), not(equalTo(0)));

    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }
}