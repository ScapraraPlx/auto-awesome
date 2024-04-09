package com.coding.skills.core.po.panels;

import ch.lambdaj.function.convert.Converter;
import com.coding.skills.core.po.WebDriverAdaptor;
import com.coding.skills.core.po.pages.AbstractPage;
import lombok.Getter;
import net.serenitybdd.core.pages.RenderedPageObjectView;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.thucydides.core.annotations.locators.SmartElementLocatorFactory;
import net.thucydides.core.annotations.locators.SmartFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

import static ch.lambdaj.Lambda.convert;

public abstract class AbstractPanel {

    private long waitForTimeoutInMilliseconds = 5000;
    @Getter
    private AbstractPage driverDelegate;
    private WebDriverAdaptor panelToWebDriver;

    protected AbstractPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        initPanel(panelBaseLocation, driverDelegate);
    }

    private void initPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        this.driverDelegate = driverDelegate;
        waitForTimeoutInMilliseconds = driverDelegate.waitForTimeoutInMilliseconds();
        panelToWebDriver = new WebDriverAdaptor(panelBaseLocation, getDriver());
        final ElementLocatorFactory finder = new SmartElementLocatorFactory(panelToWebDriver, null);
        final FieldDecorator decorator = new SmartFieldDecorator(finder, getDriver(), driverDelegate);
        PageFactory.initElements(decorator, this);
    }

    public WebDriver getDriver() {
        return driverDelegate.getDriver();
    }

    protected WebDriverAdaptor getPanelToWebDriver() {
        return panelToWebDriver;
    }

    public WebElementFacade findBy(final String xpathOrCssSelector) {
        final WebElement webElement = panelToWebDriver.findElement(xpathOrCssSelector(xpathOrCssSelector));
        return WebElementFacadeImpl.wrapWebElement(getDriver(), webElement, waitForTimeoutInMilliseconds);
    }

    public List<WebElementFacade> findMultipleBy(final String xpathOrCssSelector) {
        getDriver().manage().timeouts().implicitlyWait(Duration.of(500, ChronoUnit.MILLIS));
        List<WebElement> matchingWebElements;
        try {
            matchingWebElements = panelToWebDriver.findElements(xpathOrCssSelector(xpathOrCssSelector));
        } finally {
            getDriverDelegate().resetImplicitTimeout();
        }
        return convert(matchingWebElements, toWebElementFacades());
    }

    public RenderedPageObjectView withTimeoutOf(final int timeout, final TemporalUnit units) {
        return new RenderedPageObjectView(getDriver(), getDriverDelegate(), Duration.of(timeout, units), false);
    }

    private Converter<WebElement, WebElementFacade> toWebElementFacades() {
        return this::element;
    }

    private WebElementFacade element(final WebElement webElement) {
        return WebElementFacadeImpl.wrapWebElement(getDriver(), webElement, waitForTimeoutInMilliseconds);
    }

    private By xpathOrCssSelector(final String xpathOrCssSelector) {
        By locator;
        if (isXPath(xpathOrCssSelector)) {
            locator = By.xpath(xpathOrCssSelector);
        } else {
            locator = By.cssSelector(xpathOrCssSelector);
        }
        return locator;
    }

    private boolean isXPath(final String xpathExpression) {
        final XPathFactory factory = XPathFactory.newInstance();
        final XPath xpath = factory.newXPath();
        try {
            xpath.compile(xpathExpression);
        } catch (final Exception e) {
            return false;
        }
        return true;
    }
}
