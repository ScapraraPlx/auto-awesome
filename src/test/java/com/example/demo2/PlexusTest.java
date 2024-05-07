package com.example.demo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PlexusTest {
    private WebDriver driver;
    private PlexusMainPage plexusMainPage;

    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://plexusworldwide.com/");

        plexusMainPage = new PlexusMainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void bannerTitle() {
        String bannerTitleText = plexusMainPage.bannerTitle.getText();

        assertEquals(bannerTitleText, "Advanced absorption. Gentle delivery.");
    }

    @Test
    public void navigationToAboutPage() {
        plexusMainPage.aboutButton.click();
        new PlexusAboutPage(driver);

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://plexusworldwide.com/about?culture=en-US");
    }
}
