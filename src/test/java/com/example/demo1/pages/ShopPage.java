package com.example.demo1.pages;

import com.example.demo1.pages.interfaces.IPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShopPage extends BasePage<ShopPage> implements IPage {

    By logo = By.xpath("//a[@data-testId='pww-link-']//img[@data-testid='image']");

    @Step("Open products page")
    public ShopPage open() {
        driver.get("https://plexusworldwide.com/products");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(logo));
        return this;
    }

    @Step("Get current URL from products page")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
