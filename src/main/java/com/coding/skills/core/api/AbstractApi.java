package com.coding.skills.core.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;

public abstract class AbstractApi {

    private static final String API_BASE_URL = "https://api.demoblaze.com";

    public AbstractApi() {
        SerenityRest.setDefaultRequestSpecification(init());
    }

    private RequestSpecification init() {
        return new RequestSpecBuilder()
                .addFilters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .setBaseUri(API_BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
