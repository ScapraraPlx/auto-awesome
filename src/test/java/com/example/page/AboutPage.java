package com.example.page;

import static com.example.utils.Constants.ABOUT_PAGE;
import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

public class AboutPage extends AbstractBasePage {

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public AboutPage verifyUrlCorrectness() {
        assertThat(driver.getCurrentUrl().equals(ABOUT_PAGE))
            .as("you have been navigated to the wrong page")
            .isTrue();
        return this;
    }
}
