package com.example.demo1.ui.tests;

import com.example.demo1.ui.pages.PlexusMainPage;
import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demo1.ui.common.MenuItem.ABOUT;
import static com.example.demo1.ui.common.URLProvider.getMenuURL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

@Slf4j
public class PlexusTechTaskTest extends BaseUITest {

    private PlexusMainPage plexusMainPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
        plexusMainPage = new PlexusMainPage(driver);
    }

    @Test
    @Feature("Main Menu")
    @Story("Check top menu item on Plexus homepage")
    @Severity(SeverityLevel.CRITICAL)
    public void testMenuHeaderItemsContains() {
        log.info("retrieve header menu elements text");
        List<String> headerElementsText = plexusMainPage.getHeaderElementsTexts();

        List<String> expectedMenuItems = new ArrayList<>(Arrays.asList("Shop", "Resources", "About"));
        log.info("verify that header menu elements contains elements from list {}", expectedMenuItems);
        assertThat(headerElementsText, hasItems(expectedMenuItems.toArray(new String[0])));

        log.info("open About menu item");
        plexusMainPage.menuElementByText(ABOUT.getMenuText()).click();
        waitForLoad();
        log.info("verify loaded URL is equals to expected ...");
        Assert.assertEquals(driver.getCurrentUrl(), getMenuURL(ABOUT));
    }
}
