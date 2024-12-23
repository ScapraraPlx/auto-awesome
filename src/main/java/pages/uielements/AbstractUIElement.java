package pages.uielements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import tools.Browser;
import tools.WaitUtils;

public abstract class AbstractUIElement {
    protected WaitUtils waitUtils;
    protected WebDriver driver;
    protected Actions actions;

    public AbstractUIElement(WebElement parentElement) {
        DefaultElementLocatorFactory parentContext = new DefaultElementLocatorFactory(parentElement);
        PageFactory.initElements(parentContext, this);
        driver = Browser.getInstance();
        waitUtils = new WaitUtils(5);
        actions = new Actions(driver);
    }
}
