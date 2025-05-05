package steps;

import java.util.List;

import pages.ProductPage;
import pages.CartPage;

import static com.codeborne.selenide.Selenide.back;

/**
 * Provides step definitions for cart-related actions in UI tests.
 * Encapsulates interactions with the `ProductPage` and `CartPage` classes.
 */
public class CartSteps {

    private final ProductPage productPage;
    private final CartPage cartPage;

    public CartSteps(ProductPage productPage) {
        this.productPage = productPage;
        this.cartPage = new CartPage();
    }

    public void addProductToCart(String category, int productId, String shippingOption) {
        productPage.selectCategory(category);
        productPage.selectProductById(productId);
        productPage.selectShippingOption(shippingOption);
        productPage.addToCart();
    }

    public void navigateBackToShop() {
        back();
    }

    public void openCart() {
        productPage.getHeader().clickCart();
    }

    public Double getCartTotalPrice() {
        return cartPage.getTotalPrice();
    }

    public Double calculateCartPrice() {
        List<Double> prices = cartPage.getPurchasedProductPrices();
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }
}
