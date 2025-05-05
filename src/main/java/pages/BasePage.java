package pages;

import static com.codeborne.selenide.Selenide.page;

/**
 * Abstract base class for all page objects.
 * Provides common functionality and elements shared across pages.
 */
public abstract class BasePage {

    protected HeaderElements header;

    /**
     * Initializes the header elements for the page.
     * Uses Selenide's `page()` method to bind the elements.
     */
    public BasePage() {
        this.header = page(HeaderElements.class);
    }

    /**
     * Retrieves the header elements of the page.
     *
     * @return the header elements
     */
    public HeaderElements getHeader() {
        return header;
    }
}