package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class HeaderElements {

    @FindBy(css = "[data-test-id='header-nav-main-container']")
    private SelenideElement headerElement;

    @FindBy(id = "Shop")
    private SelenideElement shopLink;

    @FindBy(id = "Experience Plexus")
    private SelenideElement experiencePlexusLink;

    @FindBy(id = "About")
    private SelenideElement aboutLink;

    @FindBy(id = "Resources")
    private SelenideElement resourcesLink;

    @FindBy(id = "Join")
    private SelenideElement joinLink;

    @FindBy(id = "Login")
    private SelenideElement loginLink;

    @FindBy(id = "Help")
    private SelenideElement helpLink;

    @FindBy(xpath = "//*[@data-testid='shopping-action-icon']")
    private SelenideElement cartLink;

    @FindBy(xpath = "//li/*[@id='button-component']")
    private SelenideElement languageButton;

    public boolean isHeaderDisplayed() {
        return headerElement.isDisplayed();
    }

    public void clickShop() {
        shopLink.click();
    }

    public void clickExperiencePlexus() {
        experiencePlexusLink.click();
    }

    public void clickAbout() {
        aboutLink.click();
    }

    public void clickResources() {
        resourcesLink.click();
    }

    public void clickJoin() {
        joinLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void clickHelp() {
        helpLink.click();
    }

    public void clickCart() {
        cartLink.click();
    }

    public void clickLanguageButton() {
        languageButton.click();
    }

    public String getCartCountElement() {
        return cartLink.$x(".//span[contains(@class,'MuiBadge-badge')]").shouldBe(visible).getText();
    }

}