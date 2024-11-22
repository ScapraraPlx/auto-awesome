package application.pages;

import application.selectors.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPage {
    private final WebDriver driver;

    public WebPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getElementText() {
        WebElement element = driver.findElement(By.cssSelector(Selectors.header));
        return element.getText();
    }

    public void clickElement() {
        WebElement element = driver.findElement(By.cssSelector(Selectors.productPage));
        element.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
