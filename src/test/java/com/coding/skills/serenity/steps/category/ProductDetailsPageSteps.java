package com.coding.skills.serenity.steps.category;

import com.coding.skills.core.po.pages.ProductDetailsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class ProductDetailsPageSteps extends UIInteractionSteps {

    private final ProductDetailsPage productDetailsPage;

    public ProductDetailsPageSteps() {
        this.productDetailsPage = getPages().getPage(ProductDetailsPage.class);
    }

    @Step("Get opened product title")
    public String getProductName() {
        return productDetailsPage.getProductTitle();
    }
}
