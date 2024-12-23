package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ShopCategoryMenuItems {
    SKINCARE("Skincare", "/products/skincare"),
    GUT_HEALTH("Gut Health", "/products/gut-health"),
    ACTIVE_LIFESTYLE("Active Lifestyle", "/products/active-lifestyle");

    private static final String BASE_URL = "https://plexusworldwide.com";
    private final String name;
    private final String endpoint;

    public String getUrl() {
        return BASE_URL + endpoint;
    }
}
