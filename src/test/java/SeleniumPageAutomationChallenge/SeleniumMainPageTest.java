package SeleniumPageAutomationChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SeleniumMainPageTest {
    private WebDriver driver;
    private SeleniumMainPage seleniumMainPage;

    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.selenium.dev/");

        seleniumMainPage = new SeleniumMainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void getTextAndAssert() {

        String text = seleniumMainPage.seleniumText.getText();
        System.out.println("Text is:-"  + text);
        assertEquals(text, "Selenium automates browsers. That's it!");
        System.out.println("Text is asserted");
    }


    @Test
    public void urlAssertion() {

        seleniumMainPage.downloadLinkBtn.click();
        System.out.println("Current Url is:- " + driver.getCurrentUrl());
        assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/downloads/");
        System.out.println("URL's are asserted");
    }
}
