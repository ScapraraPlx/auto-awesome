package com.coding.skills.serenity.steps.category;

import com.coding.skills.core.common.dto.CategoryItemDTO;
import com.coding.skills.core.po.pages.CategoryItemsPage;
import com.coding.skills.core.po.panels.gategory.Category;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.util.List;
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
        categoryItemsPage.getCategoriesNavPanel().navigateToCategory(category);
    }

    @Step("Navigate to category item")
    public void navigateToCategoryItem(final String categoryItem) {
        categoryItemsPage.openCategoryItem(categoryItem);
    }

    @Step("Get all of the to category items")
    public List<CategoryItemDTO> getCategoryItems() {
        return categoryItemsPage.getCategoryItems();
    }
}
