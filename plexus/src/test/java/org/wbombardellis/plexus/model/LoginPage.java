package org.wbombardellis.plexus.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final By usernameLocator = By.cssSelector("input#email");
    private final By passwordLocator = By.cssSelector("input#password");
    private final By signinButtonLocator = By.cssSelector("#sign-in button");

    private final WebDriver driver;
    private final Duration timeout;

    public LoginPage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
    }

    public void inputCredentials(String username, String password) {
        var usernameInput = new WebDriverWait(driver, timeout)
                .until(d -> d.findElement(usernameLocator));
        var passwordInput = new WebDriverWait(driver, timeout)
                .until(d -> d.findElement(passwordLocator));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        var signinButton = signInButton();
        signinButton.click();
    }

    public WebElement signInButton() {
        return new WebDriverWait(driver, timeout)
                .until(d -> d.findElement(signinButtonLocator));
    }
}
