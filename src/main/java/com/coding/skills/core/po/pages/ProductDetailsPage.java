package com.coding.skills.core.po.pages;

import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends AbstractPage {

    private static final String PRODUCT_TITLE = "//div[@id='tbodyid']//h2";

    public ProductDetailsPage(final WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return findBy(PRODUCT_TITLE).getText();
    }
}
