package pages.uielements;

import enums.ShopCategoryMenuItems;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.SkinCarePage;

import java.util.List;

public class NavBarPopupMenu extends AbstractUIElement {

    @FindBy(xpath = ".//a[@data-testid='menu-item']//span")
    private List<WebElement> menuItems;

    public NavBarPopupMenu(WebElement parentElement) {
        super(parentElement);
    }

    private WebElement getMenuOption(ShopCategoryMenuItems category) {
        waitUtils.waitForElementsToBeVisible(menuItems);
        return menuItems.stream()
                .filter(el -> el.getText().equals(category.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("There's no such menu option with name '%s' on the popup", category.getName())));
    }

    private void clickMenuItem(ShopCategoryMenuItems category) {
        waitUtils.waitForElementToBeClickable(getMenuOption(category)).click();
    }

    public SkinCarePage openSkinCarePage() {
        clickMenuItem(ShopCategoryMenuItems.SKINCARE);
        return new SkinCarePage();
    }
}
