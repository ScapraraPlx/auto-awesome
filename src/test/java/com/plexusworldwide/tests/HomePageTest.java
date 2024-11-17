package com.plexusworldwide.tests;

import com.plexusworldwide.basetest.BaseTest;
import com.plexusworldwide.pages.AboutPage;
import com.plexusworldwide.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {


    @Test
    public void testPageTitle() {
        HomePage homePage = openSite();

        homePage.verifyPageTitle("Founded in gut health. Experts in microbiome. | Plexus Worldwide®");
    }

    @Test
    public void testNavigationToAboutUrl() {
        HomePage homePage = openSite();

        AboutPage aboutPage = homePage.clickAboutLink();

        aboutPage.verifyAboutLink();
    }

    @AfterSuite
    public void tearDown() {
        closeSite();
    }

}
