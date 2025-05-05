package assertions;

import com.codeborne.selenide.WebDriverRunner;
import org.assertj.core.api.SoftAssertions;

/**
 * Provides assertion methods for verifying cart-related functionality in UI tests.
 * Uses AssertJ's SoftAssertions to allow multiple assertions to be executed
 * without immediately failing the test.
 */
public class CartAssertions {

    private final SoftAssertions softAssertions = new SoftAssertions();

    /**
     * Asserts that the actual cart item count matches the expected count.
     *
     * @param expectedCount the expected number of items in the cart
     * @param actualCount   the actual number of items in the cart as a String
     */
    public void assertCartItemCount(int expectedCount, String actualCount) {
        softAssertions.assertThat(actualCount)
                .as("The cart item count does not match the expected value.")
                .isEqualTo(String.valueOf(expectedCount));
    }

    /**
     * Asserts that the actual alert message matches the expected message.
     *
     * @param expectedMessage the expected alert message
     * @param actualMessage   the actual alert message
     */
    public void assertAlertMessage(String expectedMessage, String actualMessage) {
        softAssertions.assertThat(actualMessage)
                .as("The alert message does not match the expected value.")
                .isEqualTo(expectedMessage);
    }

    /**
     * Asserts that the actual calculated price matches the expected price.
     *
     * @param expectedPrice the expected total price
     * @param actualPrice   the actual total price
     */
    public void assertCalculatedPrice(Double expectedPrice, Double actualPrice) {
        softAssertions.assertThat(actualPrice)
                .as("The calculated price does not match the expected value.")
                .isEqualTo(expectedPrice);
    }

    /**
     * Asserts that the current URL matches the expected cart page URL.
     *
     * @param expectedUrl the expected URL of the cart page
     */
    public void assertRedirectedToCartPage(String expectedUrl) {
        softAssertions.assertThat(WebDriverRunner.url())
                .as("The redirection URL does not match the expected cart page URL.")
                .isEqualTo(expectedUrl);
    }

    /**
     * Executes all collected soft assertions and reports any failures.
     */
    public void assertAll() {
        softAssertions.assertAll();
    }
}