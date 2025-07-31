package com.example.demo1.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PlexusMainPage extends BasePage {

    private static final String MUIGRID_ROOT = "//div[contains(@class, 'MuiGrid-root')]";
    private static final String MENU_ITEM = "//*//*[@data-testid='menu-item']";
    private static final String HEADER_ELEMENTS_COL = MUIGRID_ROOT + MENU_ITEM + "//*//span[@data-testid]";
    private static final String HEADER_MENU_BY_TEXT = MUIGRID_ROOT + MENU_ITEM + "//*//span[@data-testid and text()='%s']";

    public PlexusMainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement menuElementByText(String menuText) {
        return $(By.xpath(String.format(HEADER_MENU_BY_TEXT, menuText)));
    }

    public List<WebElement> getHeaderElements() {
        return $$(By.xpath(HEADER_ELEMENTS_COL));
    }

    public List<String> getHeaderElementsTexts() {
        return getHeaderElements().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
