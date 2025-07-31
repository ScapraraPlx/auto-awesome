package com.example.tests;


import com.example.page.AboutPage;
import com.example.page.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasicTestPreparation {

    protected WebDriver driver;
    protected HomePage homePage;
    protected AboutPage aboutPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        aboutPage = new AboutPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
