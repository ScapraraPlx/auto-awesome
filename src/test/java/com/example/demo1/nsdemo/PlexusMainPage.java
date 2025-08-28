package com.example.demo1.nsdemo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlexusMainPage {

    private WebDriver driver;

    // Example product card (first teaser on homepage)
    @FindBy(css = "[data-testid='product-teaser']")
    private WebElement firstProductTeaser;

    // Example "About" link in top menu
    @FindBy(css = "[data-testid='menu-item'][href*='/about']")
    private WebElement aboutLink;

    public PlexusMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstProductSku() {
        return firstProductTeaser.getAttribute("data-sku");
    }

    public String getFirstProductButtonText() {
        return firstProductTeaser.findElement(org.openqa.selenium.By.tagName("button")).getText();
    }

    public void goToAboutPage() {
        aboutLink.click();
    }
}

