package ui;

import assertions.CartAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import steps.CartSteps;

import static util.Constants.*;

public class CartTests extends BaseUiTests {

    private ProductPage productPage;
    private CartAssertions cartAssertions;
    private CartSteps cartSteps;

    @BeforeEach
    public void initializeTestPage() {
        productPage = new ProductPage();
        cartAssertions = new CartAssertions();
        cartSteps = new CartSteps(productPage);
    }

    @AfterEach
    public void assertVerification() {
        cartAssertions.assertAll();
    }

    @Test
    public void addProductToCart() {
        mainPage.navigateToProductsPage();
        cartSteps.addProductToCart(CATEGORY_WOMEN_HEALTH, FIRST_PRODUCT, SHIPPING_OPTION_ONE_TIME_PURCHASE);

        cartAssertions.assertAlertMessage(ALERT_MESSAGE, productPage.getAlertMessage());
        cartAssertions.assertCartItemCount(1, productPage.getHeader().getCartCountElement());
    }

    @Test
    public void cartUpdatesQuantityCorrectly() {
        mainPage.navigateToProductsPage();
        cartSteps.addProductToCart(CATEGORY_WOMEN_HEALTH, FIRST_PRODUCT, SHIPPING_OPTION_ONE_TIME_PURCHASE);
        productPage.clickOnBreadcrumbWithName(BREADCRUMB_SHOP);
        cartSteps.addProductToCart(CATEGORY_SKINCARE, SECOND_PRODUCT, SHIPPING_OPTION_ONE_TIME_PURCHASE);

        cartAssertions.assertAlertMessage(ALERT_MESSAGE, productPage.getAlertMessage());
        cartAssertions.assertCartItemCount(2, productPage.getHeader().getCartCountElement());
    }

    @Test
    public void cartShowsCorrectTotalPrice() {
        mainPage.navigateToProductsPage();
        cartSteps.addProductToCart(CATEGORY_SKINCARE, FIRST_PRODUCT, SHIPPING_OPTION_ONE_TIME_PURCHASE);
        cartSteps.navigateBackToShop();
        cartSteps.addProductToCart(CATEGORY_SKINCARE, SECOND_PRODUCT, SHIPPING_OPTION_ONE_TIME_PURCHASE);

        cartSteps.openCart();
        cartAssertions.assertRedirectedToCartPage(CART_PAGE_URL);
        cartAssertions.assertCalculatedPrice(cartSteps.calculateCartPrice(), cartSteps.getCartTotalPrice());
    }
}