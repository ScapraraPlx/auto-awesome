package com.example.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//*[@class=\"mt-3 col-12 col-lg-4 col-sm-4 col-md-4 ng-star-inserted\"]/div/a/span/div/div")
    public WebElement product;

    @FindBy(id = "general-navigation-bar-main-menu-shop-main-menu")
    public WebElement shopBtn ;



    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
