package com.example.demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlexusMainPage {
    @FindBy(id = "About")
    public WebElement aboutButton;

    @FindBy(css = "[data-testid='hero-banner-title']")
    public WebElement bannerTitle;

    public PlexusMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
