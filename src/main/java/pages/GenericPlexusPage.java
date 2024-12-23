package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.uielements.NavigationBar;
import tools.Browser;

public abstract class GenericPlexusPage {

    @FindBy(xpath = "//nav[@data-testid='header-nav-main-container']")
    private WebElement navBarParentElement;

    public GenericPlexusPage() {
        PageFactory.initElements(Browser.getInstance(), this);
    }

    public NavigationBar getNavBar() {
        return new NavigationBar(navBarParentElement);
    }
}
