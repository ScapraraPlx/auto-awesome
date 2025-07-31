package com.example.demo1.ui.tests;

import com.example.demo1.ui.common.DriverFactory;
import com.example.demo1.ui.common.URLProvider;
import com.example.demo1.ui.utils.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseUITest {

    protected WebDriver driver;
    protected String baseURL = URLProvider.getBaseURL();
    protected int explicitWait = Integer.parseInt(ConfigReader.get("explicitWait"));

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public static void waitForLoad() {
        new WebDriverWait(DriverFactory.getDriver(), 30).until(
            (ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

}
