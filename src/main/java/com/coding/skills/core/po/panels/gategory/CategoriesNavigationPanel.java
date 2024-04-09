package com.coding.skills.core.po.panels.gategory;

import com.coding.skills.core.po.pages.AbstractPage;
import com.coding.skills.core.po.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class CategoriesNavigationPanel extends AbstractPanel {

    private static final String NAV_CATEGORY_ITEM = ".//a[@class='list-group-item' and text()='%s']";

    public CategoriesNavigationPanel(final WebElementFacade panelLocator, final AbstractPage rootPage) {
        super(panelLocator, rootPage);
    }

    public void navigateToCategory(final Category category) {
        final String navLocator = String.format(NAV_CATEGORY_ITEM, category.getAlias());
        findBy(navLocator).click();
    }
}
