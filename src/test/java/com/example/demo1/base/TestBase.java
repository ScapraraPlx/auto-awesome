package com.example.demo1.base;

import com.example.demo1.driver.DriverManager;
import com.example.demo1.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeTest
    public  void setup() {
        WebDriver driver =  WebDriverFactory.createDriver("chrome");
        DriverManager.setDriver(driver);
    }

    @AfterTest
    public  void tearDown() {
        DriverManager.quitDriver();
    }
}
