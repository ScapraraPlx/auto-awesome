package com.example.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(css = "a.wt-button_mode_primary")
    public WebElement seeAllToolsButton;

    @FindBy(css = "nav > [data-test-marker=\"Developer Tools\"]")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;
//added shopButton
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/header[1]/pwwgen-navbar[1]/nav[1]/ul[1]/li[1]/span[2]")
    public WebElement shopButton;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
