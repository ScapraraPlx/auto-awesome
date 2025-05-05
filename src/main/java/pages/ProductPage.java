package pages;

import java.util.List;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage extends BasePage {

    public ProductPage() {
        page(this);
    }

    @FindBy(xpath = "//*[@data-testid='side-bar-menu-item-desktop']")
    private List<SelenideElement> categoryItems;

    @FindBy(xpath = "//*[@data-testid='product-teaser-view-details-button']")
    private List<SelenideElement> productItems;

    @FindBy(id = "purchase-buttons-and-options-container")
    private SelenideElement shippingOption;

    @FindBy(id = "add-to-cart")
    private SelenideElement addToCartButton;

    @FindBy(xpath = ".//*[contains(@class, 'MuiAlert-message')]")
    private SelenideElement alertMessage;

    @FindBy(xpath = ".//*[@aria-label='breadcrumb']")
    private SelenideElement breadcrumb;

    public void selectCategory(String categoryName) {
        for (SelenideElement category : categoryItems) {
            if (category.getText().equalsIgnoreCase(categoryName)) {
                category.shouldBe(visible).click();
                break;
            }
        }
    }

    public void selectProductById(int productId) {
        productItems.get(productId - 1).click();
    }

    public void selectShippingOption(String optionValue) {
        shippingOption.shouldBe(visible);
        shippingOption.$$(By.tagName("input")).stream()
                .filter(radioButton -> radioButton.getAttribute("value").equalsIgnoreCase(optionValue))
                .findFirst()
                .ifPresent(SelenideElement::click);
    }

    public void addToCart() {
        addToCartButton.shouldBe(visible).click();
    }

    public String getAlertMessage() {
        String alertText = alertMessage.shouldBe(visible).getText();
        alertMessage.should(disappear);
        return alertText;
    }

    public void clickOnBreadcrumbWithName(String name) {
        breadcrumb.$(By.xpath(".//*[contains(text(),'" + name + "')]")).click();
    }
}