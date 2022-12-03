package com.plexus.skilltest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//*[@id=\"announcement-banner\"]/a[2]")
    public WebElement promotionallink;

    @FindBy(xpath = "//*[@id=\"general-navigation-bar-main-menu-join-main-menu\"]/span[2]")
    public WebElement joinLink;

      public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
