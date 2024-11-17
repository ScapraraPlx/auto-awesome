package com.plexusworldwide.pages;

import com.plexusworldwide.basetest.BaseTest;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class AbstractPage {

    protected BaseTest testClass;

    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
    }

    public void verifyPageTitle(String title){
        String actualTitle  = testClass.getDriver().getTitle();

        assertEquals(title, actualTitle, String.format("Title does not equals %s'", title));
    }

}
