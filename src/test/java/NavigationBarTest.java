import enums.Languages;
import enums.ShopCategoryMenuItems;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class NavigationBarTest extends BaseTest {
    private static final String URL_MESSAGE = "Current URL should be equal to '%s'";
    private static final String LANGUAGE_MESSAGE = "Selected Language should be '%s'";
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = openHomePage();
    }

    @Test
    public void checkSelectedLanguage() {
        String defaultLanguage = Languages.US_EN.getName();

        Assertions.assertThat(homePage.getNavBar().getSelectedLanguage())
                .as(String.format(LANGUAGE_MESSAGE, defaultLanguage))
                .isEqualTo(defaultLanguage);
    }

    @Test
    public void checkNavigationToSkinCareShopCategory() {
        homePage.getNavBar()
                .openShopCategory()
                .openSkinCarePage();

        Assertions.assertThat(driver.getCurrentUrl())
                .as(String.format(URL_MESSAGE, ShopCategoryMenuItems.SKINCARE.getUrl()))
                .isEqualTo(ShopCategoryMenuItems.SKINCARE.getUrl());
    }
}
