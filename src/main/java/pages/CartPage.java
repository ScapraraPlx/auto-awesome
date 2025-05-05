package pages;

import java.util.List;
import java.util.stream.Collectors;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class CartPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class, 'product-purchased')]")
    private List<SelenideElement> purchasedProducts;

    @FindBy(xpath = ".//*[contains(@class, 'total')]/dd")
    private SelenideElement totalPrice;

    public CartPage() {
        page(this);
    }

    public List<Double> getPurchasedProductPrices() {
        purchasedProducts.get(0).shouldBe(visible);
        return purchasedProducts.stream()
                .map(product -> product.$x(".//*[contains(@class,'price')]/strong").getText())
                .map(text -> Double.parseDouble(text.replace("$", "")))
                .collect(Collectors.toList());
    }

    public Double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().replace("$", ""));
    }
}
