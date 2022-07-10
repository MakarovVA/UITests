package ru.makarovva.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;

import static ru.makarovva.utils.ScreenshotMaker.makeScreenshotOnFailure;

public abstract class BaseTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    static Properties properties = new Properties();
    static WebDriver driver;
    static String baseUrl;

    static String username1;
    static String username2;
    static String username3;
    static String password;
    static String firstName;
    static String lastName;
    static String postalCode;
    static String checkoutUrl;

    @BeforeAll
    static void beforeAllTests() throws IOException {
        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        baseUrl = properties.getProperty("base.url");
        username1 = properties.getProperty("standard.username");
        username2 = properties.getProperty("lockedout.username");
        username3 = properties.getProperty("problem.username");
        password = properties.getProperty("standard.password");
        firstName = properties.getProperty("my.firstName");
        lastName = properties.getProperty("my.lastName");
        postalCode = properties.getProperty("my.postalCode");
        checkoutUrl = properties.getProperty("checkout.url");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        // изменять размеры окна - на максимум
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @AfterEach
    void afterEach() throws IOException {
        Allure.addAttachment("Page screenshot", new FileInputStream(makeScreenshotOnFailure(driver)));
        driver.manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);
    }

    @AfterAll
    static void afterAll() {
        if (driver!=null){
            driver.quit();
        }
    }
}
