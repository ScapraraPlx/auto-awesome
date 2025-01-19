package com.example.demo1.UIPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {

    private final String PAGE_URL = "https://plexusworldwide.com/";

    private final SelenideElement HEADER_HOME_PAGE = $("[data-testid='main-header-option']");
    private final SelenideElement PRODUCTS_GROUP = $("[data-testid='products-group']");
    private final SelenideElement EXPERIENCE_PLEXUS_MENU_ITEM = $x("//div[@data-testid='mega-menu-label' and @id='Experience Plexus']");
    private final ElementsCollection FEATURED_PRODUCTS_ITEMS = $$("[data-testid='product-teaser-component']");
    private final String FEATURED_PRODUCTS_NAME_SELECTOR = "[data-testid='product-teaser-name']";
    private final ElementsCollection FEATURED_PRODUCTS_NAMES = $$(FEATURED_PRODUCTS_NAME_SELECTOR);
    private final String FEATURED_PRODUCTS_PRICE_SELECTOR = "[data-testid='priceUpper-component-retail-price']";
    private final ElementsCollection FEATURED_PRODUCTS_PRICES = $$(FEATURED_PRODUCTS_PRICE_SELECTOR);

    public HomePage scrollToProductGroupSection() {
        PRODUCTS_GROUP.scrollIntoView(true);
        return this;
    }

    public HomePage checkAllProductsContainNamesAndPrices() {
        Assertions.assertThat(FEATURED_PRODUCTS_ITEMS)
                .hasSameSizeAs(FEATURED_PRODUCTS_NAMES)
                .hasSameSizeAs(FEATURED_PRODUCTS_PRICES);
        FEATURED_PRODUCTS_ITEMS.shouldHave(allMatch("Each product item contains name and price blocks",
                (item) -> item.findElement(By.cssSelector(FEATURED_PRODUCTS_NAME_SELECTOR)).isDisplayed() &&
                        item.findElement(By.cssSelector(FEATURED_PRODUCTS_PRICE_SELECTOR)).isDisplayed()
        ));
        return this;
    }

    public HomePage checkHasProducts(String... values) {
        FEATURED_PRODUCTS_NAMES.should(exactTextsCaseSensitiveInAnyOrder(values));
        return this;
    }

    public HomePage navigateToExperiencePlexusPage() {
        EXPERIENCE_PLEXUS_MENU_ITEM.click();
        return this;
    }

    @Override
    protected String createUrl() {
        return PAGE_URL;
    }

    @Override
    protected boolean isValid() {
        return HEADER_HOME_PAGE.shouldBe(visible).exists();
    }
}
