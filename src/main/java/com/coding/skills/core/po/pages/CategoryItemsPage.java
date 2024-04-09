package com.coding.skills.core.po.pages;

import com.coding.skills.core.common.dto.CategoryItemDTO;
import com.coding.skills.core.po.panels.gategory.CategoriesNavigationPanel;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.substringAfter;

@DefaultUrl("https://www.demoblaze.com/index.html#")
public class CategoryItemsPage extends AbstractPage {

    private static final String CATEGORIES_PANEL = "//div[@class='list-group']";
    private static final String CATEGORY_ITEMS = "//div[@class='card h-100']";
    private static final String TITLE = ".//div[@class='card-block']//h4[@class='card-title']//a";
    private static final String PRICE = ".//div[@class='card-block']//h5";
    private static final String CATEGORY_ITEM = ".//a[text()='%s']";

    public CategoryItemsPage(final WebDriver driver) {
        super(driver);
    }

    public CategoriesNavigationPanel getCategoriesNavPanel() {
        return new CategoriesNavigationPanel(withTimeoutOf(Duration.of(10, ChronoUnit.SECONDS)).find(CATEGORIES_PANEL), this);
    }

    public void openCategoryItem(final String item) {
        findBy(String.format(CATEGORY_ITEM, item)).click();
    }

    public List<CategoryItemDTO> getCategoryItems() {
        return withTimeoutOf(Duration.of(10, ChronoUnit.SECONDS))
                .findAll(CATEGORY_ITEMS)
                .stream()
                .map(item -> {
                    final String title = item.findBy(TITLE).waitUntilVisible().getText();
                    final String price = substringAfter(item.findBy(PRICE).waitUntilVisible().getText(), "$");
                    return new CategoryItemDTO(title, price);
                }).collect(toList());
    }
}
