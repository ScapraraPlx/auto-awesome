package com.plexus.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class WebDriverBase {

	protected WebDriver driver;

	protected WebDriverWait wait;

	@BeforeClass

    public void setUp() {

        // Chrome WebDriver setup
		driver = new ChromeDriver();

		// Window Maximize
		driver.manage().window().maximize();

		// Wait WebDriver setup

	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterClass

    public void tearDown() {

        if (driver != null) {

        	// Closing the driver 
            driver.quit();  

        }

    }

    // Explicitly wait for an element to be visible
    protected WebElement waitForElement(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    
}