package com.example.demo1.UIPages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class ExperiencePlexusPage extends BasePage {

    private final String PAGE_URL = "https://plexusworldwide.com/experience-plexus";

    private final SelenideElement CANONICAL_LINK = $("[data-testid='canonical']");

    public ExperiencePlexusPage verifyUrl(String value) {
        Assert.assertEquals(value, PAGE_URL, "Page URL is incorrect");
        return this;
    }

    @Override
    protected String createUrl() {
        return PAGE_URL;
    }

    @Override
    protected boolean isValid() { return PAGE_URL.equals(CANONICAL_LINK.getAttribute("href")); }
}
