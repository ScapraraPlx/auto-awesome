package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {

    protected WebDriver driver;
    private final WebDriverWait wait;

    public AbstractBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected void waitForElementPresence(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}