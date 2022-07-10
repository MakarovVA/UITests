package ru.makarovva.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ru.makarovva.pages.LoginPage;

public class LockedOutUserTests extends BaseTest {
    @Story("Тесты для логина locked_out_user")
    @Feature("При использовании этого логина авторизация блокируется")
    @Description("Тесты для логина locked_out_user")
    @Test
    void authorisationPositiveTest() throws InterruptedException {

        new LoginPage(driver)
                .enterLogin(username2)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageUrl()
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



