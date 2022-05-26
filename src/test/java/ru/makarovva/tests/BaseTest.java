package ru.makarovva.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    static Properties properties = new Properties();
    static WebDriver driver;
    static String baseUrl;

    static String username;
    static String password;
    static String firstName;
    static String lastName;
    static String postalCode;
    static String checkoutUrl;

    @BeforeAll
    static void beforeAllTests() throws IOException {
        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        baseUrl = properties.getProperty("base.url");
        username = properties.getProperty("standard.username");
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

    @AfterAll
    static void afterAll() {
        if (driver!=null){
            driver.quit();
        }
    }
}
