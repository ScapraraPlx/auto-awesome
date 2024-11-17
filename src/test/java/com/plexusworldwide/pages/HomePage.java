package com.plexusworldwide.pages;

import com.plexusworldwide.basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"About\"]")
    public WebElement about;


    public HomePage(BaseTest testClass) {
        super(testClass);

    }

    public AboutPage clickAboutLink() {
        about.click();
        return new AboutPage(testClass);
    }
}
