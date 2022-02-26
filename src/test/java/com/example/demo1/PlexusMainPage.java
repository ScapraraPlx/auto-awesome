package com.example.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlexusMainPage {

	@FindBy(xpath = "//*[@id=\"general-navigation-bar-main-menu-shop-main-menu\"]/span[2]")
	public WebElement shopMenu;

	@FindBy(xpath = "//*[@id=\"section-group-2\"]/div/div/product-display-group/div/div/div/div[1]/div/a/span/div/div[1]")
	public WebElement plexusGutProduct;

	public PlexusMainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
