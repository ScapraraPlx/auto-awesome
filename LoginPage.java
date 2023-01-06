package skilltest;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		WebDriver driver;
		@FindBy(xpath="//img[@alt='Plexus Logo']")
		WebElement logo;
		public  LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		public void checklogo() {
			Assert.assertEquals(true, logo.isDisplayed());
			System.out.println("Logo is displayed");
}
}
