package com.example.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@data-testid=\"menu-item\"]//span[text()='About']")
    public WebElement aboutbutton;

    @FindBy(xpath = "//*[@data-testid=\"menu-item\"]//span[text()='Shop']")
    public WebElement shopButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
