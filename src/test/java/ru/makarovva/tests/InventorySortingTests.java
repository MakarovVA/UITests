package ru.makarovva.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ru.makarovva.pages.LoginPage;

public class InventorySortingTests extends BaseTest {
    @Story("Тесты на сортировку")
    @Feature("Проверка разных видов сортировки")
    @Description("Проверка разных видов сортировки")
    @Test
    void CompareSorterTest() {
        new LoginPage(driver)
                .enterLogin(username1)
                .enterPassword(password)
                .clickLoginButton()
                .sorterAtoZ()
                .sorterZtoA()
                .sorterLowToHigh()
                .sorterHighToLow()
                .compareSorting();
    }

}
