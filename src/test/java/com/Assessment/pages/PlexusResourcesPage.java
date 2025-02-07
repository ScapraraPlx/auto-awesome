package com.Assessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlexusResourcesPage {
    private WebDriver driver;

    public PlexusResourcesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeadingText() {
        WebElement heading = driver.findElement(By.tagName("h1"));
        return heading.getText().trim();
    }
}
