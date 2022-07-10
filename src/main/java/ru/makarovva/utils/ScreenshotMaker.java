package ru.makarovva.utils;

import java.io.File;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotMaker {
    @Attachment(value = "Page screenshot", type = "image/png")
    public static File makeScreenshotOnFailure(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    }
}
