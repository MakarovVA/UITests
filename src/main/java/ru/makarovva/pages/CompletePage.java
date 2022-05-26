package ru.makarovva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.makarovva.pages.BasePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CompletePage extends BasePage {


    @FindBy(id = "finish")
    private WebElement finishButton;


    public CompletePage(WebDriver driver) {
        super(driver);
        initElements(this.driver, this);
    }

    public CompletePage checkCompletePageUrl() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        return this;
    }

    public CompletePage checkImageOnThePage() {
        assertThat(driver.findElements(By.className("pony_express")).size(), not(equalTo(0)));
    return this;

    }
}