package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;
import util.ConfigLoader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

/**
 * Abstract base class for UI tests.
 * Provides common setup and teardown functionality for all UI test classes.
 */
public abstract class BaseUiTests {

    protected MainPage mainPage;
    protected static final ConfigLoader configLoader = new ConfigLoader();
    private static final String BASE_URL = configLoader.getProperty("plexus.home.page");

    @BeforeEach
    public void driverSetup() {
        open(BASE_URL);
        mainPage = new MainPage();
        mainPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
