package com.coding.skills.core.po.panels.gategory;

import com.coding.skills.core.po.pages.AbstractPage;
import com.coding.skills.core.po.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class CategoryItemPanel extends AbstractPanel {

    private static final String TITLE = ".//div[@class='card-block']//h4[@class='card-title']//a";
    private static final String PRICE = ".//div[@class='card-block']//h5";
    private static final String DESCRIPTION = ".//div[@class='card-block']//p[@id='article']";

    public CategoryItemPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void open() {
        findBy(TITLE).click();
    }

    public String getTitle() {
        return findBy(TITLE).getText();
    }

    public String getPrice() {
        return findBy(PRICE).getText();
    }

    public String getDescription() {
        return findBy(DESCRIPTION).getText();
    }
}
