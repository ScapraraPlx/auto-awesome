package application;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import application.configs.WebDriverConfig;
import application.pages.WebPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Web Testing")
@Feature("Navigation Tests")
public class WebPageTest {
    private WebDriver driver;
    private WebPage webPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverConfig.createWebDriver();
        webPage = new WebPage(driver);
    }

    @Test
    @Description("Verify navigation and content on the web page")
    public void testWebPage() {
        Allure.step("Open page https://plexusworldwide.com", () -> {
            driver.get("https://plexusworldwide.com");
        });

        Allure.step("Check header text", () -> {
            String elementText = webPage.getElementText();
            Assert.assertTrue(elementText.contains("Featured Products"), "The text does not meet expectations!");
        });

        Allure.step("Navigate to product page", () -> {
            webPage.clickElement();
        });

        Allure.step("Verify URL of the product page", () -> {
            String currentUrl = webPage.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("plexusworldwide.com/products"), "The URL is not as expected");
        });
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
