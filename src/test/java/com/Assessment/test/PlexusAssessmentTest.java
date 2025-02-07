package com.Assessment.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import com.Assessment.pages.PlexusHomePage;
import com.Assessment.pages.PlexusResourcesPage;

import static org.testng.Assert.*;

public class PlexusAssessmentTest {

    private WebDriver driver;
    private PlexusHomePage homePage;
    private PlexusResourcesPage resourcesPage;

    @BeforeClass
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get("https://plexusworldwide.com");
        homePage = new PlexusHomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void testResourcesNavigation() {
        // Navigate to Resources page
        String linkText = homePage.getResourcesLink().getText().trim();
        assertEquals(linkText, "Resources", "Link text does not match.");

        homePage.getResourcesLink().click();

        waitForUrlToContain("/resources");

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/resources"), "URL does not contain '/resources'.");

        resourcesPage = new PlexusResourcesPage(driver);
        String headingText = resourcesPage.getHeadingText();
        assertTrue(headingText.contains("Resources"), "Heading text does not contain 'Resources'.");

        // Navigate to About Us page
        homePage.getAboutUsLink().click();

        waitForUrlToContain("/about");

        String aboutUsUrl = driver.getCurrentUrl();
        assertTrue(aboutUsUrl.contains("/about"), "URL does not contain '/about'.");
    }

    private WebDriver initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        return driver;
    }

    private void waitForUrlToContain(String partialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    private void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
