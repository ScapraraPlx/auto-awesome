package org.wbombardellis.plexus.test;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wbombardellis.plexus.model.HomePage;
import org.wbombardellis.plexus.model.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageSteps {
    private final Duration defaultWaitTimeout = Duration.ofSeconds(30);

    private WebDriver driver;
    private HomePage homePage;
    private static final Logger logger = LogManager.getLogger(MainPageSteps.class);

    @Before
    public void setUp() throws MalformedURLException {
        var remoteWebDriverURL = System.getProperty("org.wbombardellis.plexus.webdriver");
        logger.info("Remote web driver URL: " + remoteWebDriverURL);
        if (remoteWebDriverURL != null)
            driver = new RemoteWebDriver(new URL(remoteWebDriverURL), new FirefoxOptions());
        else
            driver = new FirefoxDriver();

        homePage = new HomePage(driver, defaultWaitTimeout);
    }

    @After
    public void tearDown() { driver.quit(); }


    @io.cucumber.java.en.When("I open the login page")
    public void iOpenTheLoginPage() {
        homePage.home();
        logger.info("Home page loaded");
    }

    @io.cucumber.java.en.And("I click the login button")
    public void iClickTheLoginButton() {
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
    }

    @io.cucumber.java.en.Then("The login page loads")
    public void theLoginPageLoads() {
        //Assert URL matches the expected value
        var loginPage = new LoginPage(driver, defaultWaitTimeout);
        var signInButton = loginPage.signInButton();
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(ExpectedConditions.elementToBeClickable(signInButton));

        logger.info("Sign in page URL: " + driver.getCurrentUrl());
        assertTrue(ExpectedConditions.urlContains("login").apply(driver));
    }

    @Given("I am at the login page")
    public void iAmAtTheLoginPage() {
        homePage.home();

        //Navigate to sign in page
        var signInButton = homePage.signInButton();
        new WebDriverWait(driver, defaultWaitTimeout)
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        logger.info("Navigate to sign in page");
    }

    @When("I enter the following username and password")
    public void iEnterUsernameAndPassword(DataTable table) {
        var username = table.cell(0,0);
        var password = table.cell(0,1);

        var loginPage = new LoginPage(driver, defaultWaitTimeout);
        loginPage.inputCredentials(username, password);
        logger.info("Enter username and password: '"+username+"', '"+password+"'");
    }

    @Then("I see an error")
    public void iSeeAnError() {
        var errorMessage = new WebDriverWait(driver, defaultWaitTimeout)
                .until(d -> d.findElement(By.xpath("//span[contains(text(),'Incorrect Username')]")));
        assertNotNull(errorMessage);
        logger.info("Found error message: '"+ errorMessage.getText() +"'");
    }
}
