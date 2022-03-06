package org.wbombardellis.plexus.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wbombardellis.plexus.model.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    private final Duration defaultWaitTimeout = Duration.ofSeconds(30);

    private WebDriver driver;
    private HomePage homePage;
    private static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeEach
    public void setUp() throws MalformedURLException {
        var remoteWebDriverURL = System.getProperty("org.wbombardellis.plexus.webdriver");
        logger.info("Remote web driver URL: " + remoteWebDriverURL);
        if (remoteWebDriverURL != null)
            driver = new RemoteWebDriver(new URL(remoteWebDriverURL), new FirefoxOptions());
        else
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
        logger.info("Home page loaded");

        //Switch to accept cookies iframe
        var acceptCookiesIframe = homePage.acceptCookiesIframe();
        driver.switchTo().frame(acceptCookiesIframe);
        logger.info("Switched to accept cookies iframe");

        //Accept all cookies
        var acceptCookiesButton = homePage.acceptCookiesButton();
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(d -> acceptCookiesButton.isEnabled());
        acceptCookiesButton.click();
        logger.info("Accepted all cookies");

        //Back to default iframe, wait for overlay to disappear
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(ExpectedConditions.stalenessOf(acceptCookiesIframe));
        logger.info("Back to default iframe");

        //Assert Sign in button has correct text
        var signInButton = homePage.signInButton();
        String sigInText = signInButton.getText();
        logger.info("Sign in button text: " + sigInText);
        assertEquals("Sign In", sigInText);

        //Navigate to sign in page
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        logger.info("Navigate to sign in page");

        //Assert URL matches the expected value
        logger.info("Sign in page URL: " + driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().matches(".*login.*"));
    }
}
