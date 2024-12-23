package pages.uielements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractUIElement {

    @FindBy(xpath = ".//div[@id='Shop']")
    private WebElement shopCategory;

    @FindBy(xpath = ".//li[contains(@class,'marketSelector')]/button")
    private WebElement languageSelector;

    @FindBy(xpath = "//div[@role='presentation']")
    private WebElement popUpParentElement;

    public NavigationBar(WebElement parentElement) {
        super(parentElement);
    }

    public NavBarPopupMenu openShopCategory() {
        waitUtils.waitForElementToBeVisible(shopCategory);
        actions.moveToElement(shopCategory).perform();
        return new NavBarPopupMenu(popUpParentElement);
    }

    public String getSelectedLanguage() {
        waitUtils.waitForElementToBeVisible(languageSelector);
        return languageSelector.getText();
    }
}
