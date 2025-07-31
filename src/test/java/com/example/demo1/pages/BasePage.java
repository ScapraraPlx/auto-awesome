package com.example.demo1.pages;

import com.example.demo1.driver.DriverManager;
import com.example.demo1.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage<T> {
    protected WebDriver driver;
    private Duration timout = Duration.ofSeconds(10);

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public Duration getTimout() {
        return timout;
    }

    public WebDriverWait getWait() {
        return  new WebDriverWait(this.driver, getTimout());
    }
}
