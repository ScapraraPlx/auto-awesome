package com.plexusworldwide.pages;

import com.plexusworldwide.basetest.BaseTest;

import static org.testng.Assert.assertTrue;

public class AboutPage extends AbstractPage{

    public AboutPage(BaseTest testClass) {
        super(testClass);
    }

    public void verifyAboutLink(){
        String currentUrl  = testClass.getDriver().getCurrentUrl();

        assertTrue(currentUrl.contains("/about"), "URL does not contain '/about'");
    }
}
