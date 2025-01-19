package com.example.demo1;

import com.codeborne.selenide.WebDriverRunner;
import com.example.demo1.UIPages.ExperiencePlexusPage;
import com.example.demo1.UIPages.HomePage;
import com.example.demo1.ui.SeleniumSetup;
import org.testng.annotations.Test;

import static com.example.demo1.UIPages.BasePage.expect;
import static com.example.demo1.UIPages.BasePage.open;

public class WelcomePageTest extends SeleniumSetup {

    @Test
    void verifyExpectedProductsAreShownOnMainPage() {
        open(HomePage.class)
                .scrollToProductGroupSection()
                .checkAllProductsContainNamesAndPrices()
                .checkHasProducts("TriPlex - Bio Cleanse 60®", "TriPlex and Trim Combo", "Plexus Reset™");
    }

    @Test
    void verifyRedirectFromMainPageToVipCustomersPage() {
        open(HomePage.class).navigateToExperiencePlexusPage();
        expect(ExperiencePlexusPage.class).verifyUrl(WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
