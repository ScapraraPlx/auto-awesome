package com.coding.skills.serenity.steps.category;

import com.coding.skills.core.common.dto.CategoryItemDTO;
import com.coding.skills.core.po.pages.CategoryItemsPage;
import com.coding.skills.core.po.panels.gategory.Category;
import com.coding.skills.core.po.panels.gategory.CategoryItemPanel;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.pages.Pages;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class CategoryPageSteps extends UIInteractionSteps {

    private final CategoryItemsPage categoryItemsPage;

    public CategoryPageSteps() {
        this.categoryItemsPage = getPages().getPage(CategoryItemsPage.class);
    }

    @Step("Navigate to Categories page")
    public void openAt() {
        categoryItemsPage.open();
    }

    @Step("Navigate to category item")
    public void navigateToCategory(final Category category) {
        categoryItemsPage.getCategoriesPanel().navigateToCategory(category);
    }

    @Step("Navigate to category item")
    public void navigateToCategoryItem(final String categoryItem) {
        final CategoryItemPanel categoryItemPanel = categoryItemsPage.getCategoryItems()
                .stream()
                .filter(item -> StringUtils.equals(item.getTitle(), categoryItem))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("The requested resource was not found."));
        categoryItemPanel.open();
    }

    @Step("Get all of the to category items")
    public List<CategoryItemDTO> getCategoryItems() {
        return categoryItemsPage.getCategoryItems().stream().map(item -> {
            final String title = item.getTitle();
            final String price = item.getPrice();
            final String description = item.getDescription();
            return new CategoryItemDTO(title, price, description);
        }).collect(Collectors.toList());
    }
}
