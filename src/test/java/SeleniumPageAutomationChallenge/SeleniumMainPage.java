package SeleniumPageAutomationChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumMainPage {

    @FindBy(xpath = "//h1[@class='display-1 mt-0 mt-md-5 pb-1']")
    public WebElement seleniumText;

    @FindBy(xpath = "//span[normalize-space()='Downloads']")
    public WebElement downloadLinkBtn;



    public SeleniumMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
