package org.wbombardellis.plexus.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final String homeURL = "https://plexusworldwide.com";
    private final By signInBtnLocator = By.cssSelector("#general-navigation-bar-myaccount");
    private final By acceptCookiesIframeLocator = By.cssSelector(".truste_popframe");
    private final By acceptCookiesButtonLocator = By.cssSelector("a.call");
    private final By acceptCookiesOverlayLocator = By.cssSelector(".truste_overlay");

    private final WebDriver driver;
    private final Duration timeout;

    public HomePage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
    }

    public void home() {
        driver.get(homeURL);
    }

    public WebElement signInButton(){
        return driver.findElement(signInBtnLocator);
    }

    public WebElement acceptCookiesIframe() {
        return new WebDriverWait(driver, timeout)
                .until(d -> d.findElement(acceptCookiesIframeLocator));
    }

    public WebElement acceptCookiesButton() {
        return new WebDriverWait(driver, timeout)
                .until(d -> driver.findElement(acceptCookiesButtonLocator));
    }

    public WebElement acceptCookiesOverlay() {
        return new WebDriverWait(driver, timeout)
                .until(d -> driver.findElement(acceptCookiesOverlayLocator));

    }
}
