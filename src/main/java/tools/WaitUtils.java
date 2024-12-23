package tools;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    private FluentWait<WebDriver> wait;

    public WaitUtils(int timeoutInSeconds) {
        this.wait = getWebDriverWait(timeoutInSeconds);
    }

    public WebElement waitForElementToBeVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public List<WebElement> waitForElementsToBeVisible(List<WebElement> list) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public static FluentWait<WebDriver> getWebDriverWait(int timeInSeconds) {
        return new FluentWait<>(Browser.getInstance()).withTimeout(Duration.ofSeconds(timeInSeconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
    }
}
