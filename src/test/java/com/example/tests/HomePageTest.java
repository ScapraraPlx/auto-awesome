package com.example.tests;

import org.testng.annotations.Test;

public class HomePageTest extends BasicTestPreparation {

    @Test
    public void taskTest() {
        homePage
            .openHomePageAndCloseNotification()
            .verifyHeaderIsDisplayed()
            .goToAboutPage();


        aboutPage
            .verifyUrlCorrectness();
    }
}