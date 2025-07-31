package com.example.demo1.ui.tests;

import com.example.demo1.ui.common.DriverFactory;
import com.example.demo1.ui.pages.JetBrainsMainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JetBrainsMainPageTest extends BaseUITest {

    private JetBrainsMainPage mainPage;
    private static final String MAIN_PAGE_URL = "https://www.jetbrains.com/";

    @BeforeMethod
    public void beforeMethod() {
        driver.get(MAIN_PAGE_URL);
        mainPage = new JetBrainsMainPage(driver);
    }

    @Test
    public void search() {
        mainPage.searchButton.click();
        mainPage.searchField.sendKeys("Selenium");
        mainPage.submitButton.click();
        assertEquals(mainPage.searchPageField.getAttribute("value"), "Selenium");
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();
        assertTrue(mainPage.menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();
        assertTrue(mainPage.productsList.isDisplayed());
        assertEquals(DriverFactory.getDriver().getTitle(), "All Developer Tools and Products by JetBrains");
    }
}
