package com.example.demo1.ui.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    private static WebDriverWait wait;

    public static void init(WebDriver driver, int timeoutInSeconds) {
        wait = new WebDriverWait(driver, timeoutInSeconds);
    }

    public static WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
