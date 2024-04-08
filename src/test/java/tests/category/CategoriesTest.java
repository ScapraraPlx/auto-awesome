package tests.category;

import com.coding.skills.core.common.dto.CategoryItemDTO;
import com.coding.skills.core.po.panels.gategory.Category;
import com.coding.skills.serenity.steps.category.CategoriesApiSteps;
import com.coding.skills.serenity.steps.category.CategoryPageSteps;
import com.coding.skills.serenity.steps.category.ProductDetailsPageSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class CategoriesTest {

    @Steps
    private CategoryPageSteps categoryPageSteps;

    @Steps
    private ProductDetailsPageSteps productDetailsPageSteps;

    private final CategoriesApiSteps categoriesApiSteps = new CategoriesApiSteps();

    private static final String REQUESTED_PRODUCT_TITLE = "Samsung galaxy s6";

    @Test
    @Title("Verify the list of the categories")
    public void validateCategoriesTest() {
        // Open Categories page
        categoryPageSteps.openAt();

        // Open 'Phones' category
        categoryPageSteps.navigateToCategory(Category.PHONES);

        // Receive the list of the available categories from the site
        final List<CategoryItemDTO> actualCategoryItems = categoryPageSteps.getCategoryItems();

        // Receive the list of the available categories from the API
        final List<CategoryItemDTO> expectedCategoryItems = categoriesApiSteps.getCategoryItems("phone");

        // Compare expected and actual results
        Serenity.reportThat("Mismatching between expected and actual categories found.",
                () -> assertThat(actualCategoryItems)
                        .usingRecursiveComparison()
                        .ignoringCollectionOrder()
                        .isEqualTo(expectedCategoryItems)
        );

        // Navigate to the product details page
        categoryPageSteps.navigateToCategoryItem(REQUESTED_PRODUCT_TITLE);

        // Receive the opened product title
        final String actualCategoryItemTitle = productDetailsPageSteps.getProductName();

        // Assert correct page was opened
        Serenity.reportThat("Incorrect product page was opened.",
                () -> assertThat(actualCategoryItemTitle)
                        .isEqualTo(REQUESTED_PRODUCT_TITLE)
        );
    }
}
