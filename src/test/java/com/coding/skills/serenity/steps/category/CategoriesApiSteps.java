package com.coding.skills.serenity.steps.category;

import com.coding.skills.core.api.AbstractApi;
import com.coding.skills.core.common.dto.CategoryItemDTO;
import com.coding.skills.core.po.panels.gategory.Category;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;
import java.util.Map;

public class CategoriesApiSteps extends AbstractApi {

    private static final String CATEGORIES_ENDPOINT = "/bycat";
    private static final String ITEMS_JSON_PATH = "Items";

    public List<CategoryItemDTO> getCategoryItems(final String category) {
        final Map<String, String> payload = Map.of("cat", category);

        final Response response = SerenityRest.given()
                .body(payload)
                .post(CATEGORIES_ENDPOINT);

        return response.jsonPath().getList(ITEMS_JSON_PATH, CategoryItemDTO.class);
    }
}
