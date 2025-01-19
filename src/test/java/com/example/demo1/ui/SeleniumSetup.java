package com.example.demo1.ui;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public abstract class SeleniumSetup {
    public static WebDriver driver;

    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 10000;
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

