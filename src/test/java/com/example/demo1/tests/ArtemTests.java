package com.example.demo1.tests;

import com.example.demo1.base.TestBase;
import com.example.demo1.pages.MainPage;
import com.example.demo1.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArtemTests extends TestBase {

    @Test
    void testOpenMainPageAndCheckTextInAnnouncementBanner() {
        Assert.assertFalse(new MainPage()
                .open()
                .getTextFromAnnouncementBanner()
                .isBlank(), "Banner text is empty or absent");
    }

    @Test()
    void testOpenMainPageAndGoToShopPage(){
        new MainPage()
                .open()
                .clickOnShopSection();
        Assert.assertTrue(new ShopPage()
                .getCurrentUrl()
                .matches(".*/products.*"), "Opened page is not Shop page");
    }
}
