package com.example.demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlexusAboutPage {

    @FindBy(css = "[data-testid='hero-banner-title']")
    public WebElement bannerTitle;

    public PlexusAboutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
