package skilltest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Navigate2 {

	
	String driverPath = "C:\\\\Users\\\\14254\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe";
	WebDriver driver; 
	LoginPage objLoginPage;
	siginpage objsiginpage;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\14254\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Launching browser");
		driver.get("https://plexusworldwide.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}		
	@Test(priority=1)
	public void navigatingtohomepage()  {
		objLoginPage = new LoginPage(driver);
		objLoginPage.checklogo();
	}
	
	@Test(priority=2)
	
 		public void navigatingtosingin() throws Throwable {
		objsiginpage = new siginpage(driver);
		objsiginpage.checksingin();
	}
	
	@AfterTest
	public void terminateBrowser(){
	driver.quit();
	}
}
