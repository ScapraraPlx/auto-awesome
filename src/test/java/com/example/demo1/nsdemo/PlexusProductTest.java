package com.example.demo1.nsdemo;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PlexusProductTest {

    private WebDriver driver;
    private PlexusMainPage plexusMainPage; // page object like your MainPage
    private WebDriverWait wait;
    @BeforeTest
    public void setupClass() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

    }


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://plexusworldwide.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        plexusMainPage = new PlexusMainPage(driver); // similar to your MainPage init
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void getProductData_and_Navigate_then_AssertUrl() {
        // 1) Wait for a product teaser card rendered on the homepage
        By teaser = By.xpath("//div[@data-testid='product-teaser-component' and contains(@class, 'MuiGrid-item')]");
        WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(teaser));

        // 2) Retrieve product data
        String sku = card.getAttribute("data-sku"); // e.g., K1-DNCM-0329
        Assert.assertNotNull(sku, "SKU should not be null");

    // Optional: assert the 'View Details' button exists on the card
        WebElement viewDetailsBtn = card.findElement(By.xpath(".//button[@data-testid='product-teaser-view-details-button']"));
        Assert.assertTrue(viewDetailsBtn.isDisplayed(), "'View Details' button should be visible");

          // Optional: grab product name via card image alt or inner title if present
        String name = "";
        try {
            name = card.findElement(By.cssSelector("[data-testid='image']")).getAttribute("alt").trim();
        } catch (NoSuchElementException ignored) {}
        Assert.assertTrue(!name.isBlank(), "Product name (image alt) should not be blank");

        // 3) Navigate to another page on the same site (use teaser link to product page)
        WebElement productLink = card.findElement(By.cssSelector("[data-testid='product-teaser-link']"));
        productLink.click();

        // 4) Assert URL for the new page (PDP uses /product/…)
        wait.until(ExpectedConditions.urlContains("/product/"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/product/"), "URL should contain '/product/'");
   }



}
