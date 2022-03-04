package org.wbombardellis.plexus.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wbombardellis.plexus.model.HomePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    private final Duration defaultWaitTimeout = Duration.ofSeconds(30);

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUpClass(){
        System.setProperty("webdriver.gecko.driver","/home/wbombardellis/Selenium/geckodriver-v0.30.0-linux64/geckodriver");

        driver = new FirefoxDriver();
        homePage = new HomePage(driver, defaultWaitTimeout);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void SignInButtonTest() {
        //Open the home page
        homePage.home();
        var overlay = homePage.acceptCookiesOverlay();

        //Switch to accept cookies iframe
        var acceptCookiesIframe = homePage.acceptCookiesIframe();
        driver.switchTo().frame(acceptCookiesIframe);

        //Accept all cookies
        var acceptCookiesButton = homePage.acceptCookiesButton();
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(d -> acceptCookiesButton.isEnabled());
        acceptCookiesButton.click();

        //Back to default iframe, wait for overlay to disappear
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(ExpectedConditions.stalenessOf(acceptCookiesIframe));

        //Assert Sign in button has correct text
        var signInButton = homePage.signInButton();
        String sigInText = signInButton.getText();
        assertEquals("Sign In", sigInText);

        //Navigate to sign in page
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();

        //Assert URL matches the expected value
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().matches("https\\://login\\.plexusworldwide\\.com.*"));
    }
}
