import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import tools.Browser;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public static final String BASE_URL = "https://plexusworldwide.com/";

    @BeforeMethod()
    public void setUp() {
        this.driver = Browser.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void quitApp() {
        Browser.quit();
    }

    public HomePage openHomePage() {
        driver.get(BASE_URL);
        return new HomePage();
    }
}
