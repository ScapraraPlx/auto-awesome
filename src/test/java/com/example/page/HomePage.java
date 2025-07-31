package com.example.page;

import static com.example.utils.Constants.HOME_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'About')]")
    private WebElement aboutPageButton;
    @FindBy(xpath = "//div[@data-testid='main-header-option']")
    private WebElement header;

    public HomePage openHomePageAndCloseNotification() {
        driver.get(HOME_PAGE);
        return this;
    }

    public void goToAboutPage() {
        aboutPageButton.click();
    }

    public HomePage verifyHeaderIsDisplayed() {
        assertThat(header.isDisplayed())
            .as("header isn't visible")
            .isTrue();
        return this;
    }
}