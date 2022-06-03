package ru.makarovva.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ru.makarovva.pages.LoginPage;


public class ProblemUserTests extends BaseTest {
    @Story("Тесты для логина problem_user")
    @Feature("При использовании этого логина невозможно корректно ввести информацию о клиенте")
    @Description("Тесты для логина problem_user")
    @Test
    void authorisationPositiveTest() throws InterruptedException {

        new LoginPage(driver)
                .enterLogin(username3)
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
