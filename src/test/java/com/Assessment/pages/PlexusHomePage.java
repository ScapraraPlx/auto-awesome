package com.Assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlexusHomePage {
    private WebDriver driver;

    public PlexusHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getResourcesLink() {
        return driver.findElement(By.linkText("Resources"));
    }

    public WebElement getAboutUsLink() {
        return driver.findElement(By.linkText("About"));
    }
}
