# auto-awesome
Automation Test Repo
\### README

## Project Overview
This project is a UI test automation framework built using Java, Maven, and Selenide. It is designed to test the functionality of an e-commerce website, focusing on the cart-related features. The framework uses AssertJ for soft assertions and follows a modular structure with clear separation of concerns between pages, steps, and assertions.

## What Was Done
1. **Test Implementation**:
    - Created test cases in `CartTests` to validate cart functionality:
        - Adding a product to the cart.
        - Updating the cart quantity.
        - Verifying the total price in the cart.
    - Used `@BeforeEach` to initialize test dependencies and `@AfterEach` to verify all soft assertions.

2. **Assertions**:
    - Implemented `CartAssertions` to centralize and simplify soft assertions for:
        - Cart item count.
        - Alert messages.
        - Total price calculation.
        - URL redirection.

3. **Page Object Model**:
    - Developed `ProductPage` and `CartPage` classes to encapsulate UI interactions.
    - Used Selenide for element handling and actions.

4. **Steps Abstraction**:
    - Created `CartSteps` to define reusable workflows, such as adding products to the cart and navigating between pages.

5. **Soft Assertions**:
    - Integrated AssertJ's `SoftAssertions` to allow multiple assertions to be executed and reported collectively.

6. **Driver Management**:
    - Leveraged Selenide's built-in WebDriver management for setup and teardown.

## Future Improvements
1. **Test Coverage**:
    - Add more test cases for edge scenarios, such as invalid inputs, empty cart behavior, and multi-shipping options.

2. **Dynamic Data Handling**:
    - Implement data-driven testing to validate cart functionality with multiple datasets.

3. **Error Handling**:
    - Enhance error reporting for failed assertions with screenshots or logs.

4. **Parallel Execution**:
    - Configure parallel test execution to improve test suite performance.

5. **Environment Support**:
    - Add support for running tests in multiple environments (e.g., staging, production) and browsers.

6. **Reporting**:
    - Integrate a reporting tool like Allure or ExtentReports for detailed test execution reports.

7. **CI/CD Integration**:
    - Set up continuous integration pipelines (e.g., GitHub Actions, Jenkins) to automate test execution. 
   
8. **Localization Testing**:
    - Add support for testing the application in multiple languages.