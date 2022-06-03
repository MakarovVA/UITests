package ru.makarovva.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ru.makarovva.pages.LoginPage;

public class FooterTests extends BaseTest{
    @Story("Тесты подвала")
    @Feature("Проверка перехода по сссылке LinkedIn")
    @Description("Тесты подвала")
    @Test
    void goToLinkedInTest(){
        new LoginPage(driver)
                .enterLogin(username1)
                .enterPassword(password)
                .clickLoginButton()
                .goToLinkedIn();


    }
}
