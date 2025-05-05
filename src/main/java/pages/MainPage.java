package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    public MainPage() {
        page(this);
    }

    @FindBy(id = "truste-consent-required")
    private SelenideElement requiredCookies;

    public void navigateToProductsPage() {
        getHeader().clickShop();
        actions().moveByOffset(0, 0).perform();
    }

    public void acceptCookies() {
        if (requiredCookies.isDisplayed()) {
            requiredCookies.click();
        }
    }
}