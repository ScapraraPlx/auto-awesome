package com.example.demo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;



public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

String url ="https://plexusworldwide.com/";
    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validateProductName() {
String expectedProductName ="Joyōme™ Multi-Action Collagen Complex";
        String actualTitle = driver.getTitle();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(actualTitle));



String productName = mainPage.product.getText();

        Assert.assertEquals(productName,expectedProductName);

    }

    @Test
    public void NaviagteToProducts() {
        mainPage.shopBtn.click();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(url));


    }

    @Test @Ignore
    public void navigationToAllTools() {
    }
}
