package skilltest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class siginpage {
	WebDriver driver;
	@FindBy(className="MegaMenu_headerRightCopy__3Ae8x")
	WebElement signinbutton;

	
	public  siginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//@SuppressWarnings("deprecation")
	public void checksingin() throws Throwable {
		signinbutton.click();
		Thread.sleep(300);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://plexusworldwide.com/login?culture=en-US" );
		System.out.println("Navigated to Sign In page");
	}
}
