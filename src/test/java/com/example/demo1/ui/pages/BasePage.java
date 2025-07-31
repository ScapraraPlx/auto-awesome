package com.example.demo1.ui.pages;

import com.example.demo1.ui.utils.ConfigReader;
import com.example.demo1.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected int explicitWait = Integer.parseInt(ConfigReader.get("explicitWait"));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WaitUtil.init(driver, explicitWait);
    }

    public WebElement $(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> $$(By by) {
        return driver.findElements(by);
    }

}
