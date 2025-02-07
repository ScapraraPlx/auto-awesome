package com.plexus.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * Test class for automating Plexus Worldwide website navigation and verification.
 *
 * Test Steps:
 * 1. Open https://www.plexusworldwide.com.
 * 2. Retrieve and verify the subtitle text.
 * 3. Click on the 'About' button.
 * 4. Verify that the new page URL contains 'about'.
 */


public class PlexusSiteAutomationTest extends WebDriverBase{

@Test
    public void performTest() {

   // Step 1: Navigate to Plexus Worldwide webpage
         driver.get("https://www.plexusworldwide.com");

       
        // Step 2: Retrieve the subtitle text
         WebElement subtitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[data-testid='hero-banner-title']")));
         String subtitleText = subtitleElement.getText();
 
       
        // Step 3: Assert that the subtitle matches the expected value
         Assert.assertEquals(subtitleText, "Reset your metabolism, cravings, and gut.", "Subtitle text does not match the expected value.");
            
       
         // Step 4: Click on the 'About' button  
          WebElement AboutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='menu-item-content-copy' and text()='About']")));
          AboutButton.click();
         
 
        // Step 5: Verify that the URL contains 'about'
         String currentUrl = driver.getCurrentUrl();
         Assert.assertTrue(currentUrl.contains("about"), "URL does not contain 'about");

    }

}