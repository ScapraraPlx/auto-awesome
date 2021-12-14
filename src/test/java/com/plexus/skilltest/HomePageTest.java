package com.plexus.skilltest;
import com.example.demo1.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;

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
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void clickPromotionalDetails() {
        homePage.promotionallink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dialogbox = driver.findElement(By.xpath("//button[@class='pwwgen-dialog__close-button']\n"));
        String getText = driver.findElement(By.xpath("//h5/div")).getText();
        Assert.assertEquals(getText,"Monthly Incentives");
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='pwwgen-dialog__close-button']"));
        closeButton.click();

    }

    @Test
    public void clickJoinLink() {
        homePage.joinLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actText = driver.findElement(By.xpath("//div/div/span/div/h2/span")).getText();
        Assert.assertEquals(actText,"Join our community");
           }



}
