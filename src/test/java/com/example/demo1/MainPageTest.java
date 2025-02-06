package com.example.demo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://plexusworldwide.com/");
        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void retrievetext() {
        mainPage.aboutbutton.click();
        String actualText = driver.findElement(By.cssSelector("[data-testid=\"hero-banner-content-area\"]>h1")).getText();
        String expectedText = "About Plexus®";
        assertEquals(actualText, expectedText);
    }

    @Test
    public void shopMenu() {
        mainPage.shopButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/products"));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://plexusworldwide.com/products?culture=en-US";
        assertEquals(actualUrl, expectedUrl);
    }
}
