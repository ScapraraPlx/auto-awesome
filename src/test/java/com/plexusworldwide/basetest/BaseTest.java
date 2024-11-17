package com.plexusworldwide.basetest;

import java.time.Duration;

import com.plexusworldwide.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static final String BASE_URL = "https://plexusworldwide.com/";
    private WebDriver driver;


    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public WebDriver getDriver() {
        return driver;
    }

    public HomePage openSite() {
        driver.get(BASE_URL);
        return new HomePage(this);
    }

    public void closeSite() {
        driver.quit();
    }
}
