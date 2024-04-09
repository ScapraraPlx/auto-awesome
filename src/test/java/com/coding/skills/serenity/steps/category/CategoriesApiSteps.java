package com.coding.skills.serenity.steps.category;

import com.coding.skills.core.api.AbstractApi;
import com.coding.skills.core.common.dto.CategoryItemDTO;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Double.*;

public class CategoriesApiSteps extends AbstractApi {

    private static final String CATEGORIES_ENDPOINT = "/bycat";
    private static final String ITEMS_JSON_PATH = "Items";

    @Step("Receiving the list of the category items fro the API")
    public List<CategoryItemDTO> getCategoryItems(final String category) {
        final Map<String, String> payload = Map.of("cat", category);
        final Response response = SerenityRest.given()
                .body(payload)
                .post(CATEGORIES_ENDPOINT);
        final List<CategoryItemDTO> rawData = response.jsonPath().getList(ITEMS_JSON_PATH, CategoryItemDTO.class);
        return reformatCategoriesItems(rawData);
    }

    private List<CategoryItemDTO> reformatCategoriesItems(final List<CategoryItemDTO> categoryItems) {
        return categoryItems.stream().map(item -> {
            final String title = item.getTitle();
            final String reformatPrice = String.valueOf(valueOf(item.getPrice()).intValue());
            return new CategoryItemDTO(title, reformatPrice);
        }).collect(Collectors.toList());
    }
}
