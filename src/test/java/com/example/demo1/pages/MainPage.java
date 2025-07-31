package com.example.demo1.pages;

import com.example.demo1.pages.interfaces.IPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage<MainPage> implements IPage {

    By logo = By.xpath("//a[@data-testId='pww-link-']//img[@data-testid='image']");
    By announcementBannerTitle = By.xpath("//span[@data-testId='announcement-banner-title']");

    By sectionShopInMenu = By.xpath("//a[@data-testid='menu-item']//*[text()='Shop']");

    @Step("Open main page")
    public MainPage open(){
        driver.get("https://plexusworldwide.com/");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(logo));
        return this;
    }
    @Step("Get text from Announcement Banner")
    public String getTextFromAnnouncementBanner() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(announcementBannerTitle));
        return driver.findElement(announcementBannerTitle).getText();
    }

    @Step("Click on Shop section in top menu")
    public MainPage clickOnShopSection() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(sectionShopInMenu));
        driver.findElement(sectionShopInMenu).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(announcementBannerTitle));
        return this;
    }
}
