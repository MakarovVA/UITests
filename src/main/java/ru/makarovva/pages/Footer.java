package ru.makarovva.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class Footer extends BasePage {
    @FindBy(css = ".social_twitter a")
    WebElement twitterButton = null;
    @FindBy(css = ".social_facebook a")
    WebElement facebookButton = null;
    @FindBy(css = ".social_linkedin a")
    WebElement linkedInButton = null;

    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logOutButton;


    public Footer(WebDriver driver) {
        super(driver);

    }

    @Step("Переход на сайт LinkedIn")
    public void goToLinkedIn() {
        linkedInButton.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertThat(driver.getCurrentUrl(), containsString("linkedin.com"));

    }

}
