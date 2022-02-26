package com.example.demo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PlexusTest {

	private WebDriver driver;
	private PlexusMainPage mainPage;

	@BeforeTest
	static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.plexusworldwide.com/");

		mainPage = new PlexusMainPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void plexusGutProduct() {

		assertEquals(mainPage.plexusGutProduct.getText(), "Plexus Slim® Microbiome Activating*");
	}

	@Test
	public void shopMenu() {
		String shopMenuUrl = null;
		mainPage.shopMenu.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver
				.findElement(By.xpath(
						"//*[@id=\"gut-health\"]/section/div/div/div/div/div[2]/product-list-item/div/div[2]/h2/a"))
				.isDisplayed()) {
			shopMenuUrl = driver.getCurrentUrl();
		}

		assertEquals(shopMenuUrl, "https://shop.plexusworldwide.com/products");
	}

}
