package skilltest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class Navigation {
	
	public static void main(String[] args) throws Exception {
		Launch();
	}
	public static  void Launch() throws Exception {
		
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\14254\\Downloads\\chromedriver_win32\\chromedriver.exe");
 		WebDriver driver = new ChromeDriver();
 		//Launching the URL
 		driver.get("https://plexusworldwide.com/");
 		System.out.println(driver.getTitle());
 		//Verifying if logo is present
 		WebElement logo = driver.findElement(By.xpath("//img[@alt='Plexus Logo']"));
 		Assert.assertEquals(true, logo.isDisplayed());
 		System.out.println("Logo is displayed");
 		driver.manage().window().maximize();
 		//Navigating to sign in page
 		WebElement signin = driver.findElement(By.className("MegaMenu_headerRightCopy__3Ae8x"));
		signin.click();
		Thread.sleep(400);
		String URL = driver.getCurrentUrl();
		//verifying sign in URL
		Assert.assertEquals(URL, "https://plexusworldwide.com/login?culture=en-US" );
		System.out.println("Navigated to Sign In page");
		driver.quit();
	
	}
}
