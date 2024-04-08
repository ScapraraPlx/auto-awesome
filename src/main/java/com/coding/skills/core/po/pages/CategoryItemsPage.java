package com.coding.skills.core.po.pages;

import com.coding.skills.core.po.panels.gategory.CategoriesNavigationPanel;
import com.coding.skills.core.po.panels.gategory.CategoryItemPanel;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.util.stream.Collectors.toList;

@DefaultUrl("https://www.demoblaze.com/index.html#")
public class CategoryItemsPage extends AbstractPage {

    private static final String CATEGORIES_PANEL = "//div[@class='list-group']";
    private static final String CATEGORY_ITEMS = "//div[@class='card h-100']";

    public CategoryItemsPage(final WebDriver driver) {
        super(driver);
    }

    public CategoriesNavigationPanel getCategoriesPanel() {
        return new CategoriesNavigationPanel(withTimeoutOf(Duration.of(10, ChronoUnit.SECONDS)).find(CATEGORIES_PANEL), this);
    }

    public List<CategoryItemPanel> getCategoryItems() {
        return findAll(CATEGORY_ITEMS)
                .stream()
                .map(this::getCategoryItemPanel)
                .collect(toList());
    }

    private CategoryItemPanel getCategoryItemPanel(final WebElementFacade location) {
        return new CategoryItemPanel(location, this);
    }
}
