package ru.makarovva.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.makarovva.pages.BasePage;

import static org.openqa.selenium.support.PageFactory.initElements;

public class FinishPage extends BasePage {


    @FindBy(id = "finish")
    private WebElement finishButton;


    public FinishPage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    @Step("Нажать кнопку Finish")
    public CompletePage clickFinishButton() {
        finishButton.click();
        return new CompletePage(driver);
    }
}