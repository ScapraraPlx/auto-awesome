Feature: Home Page

  Scenario: Open home page and open the login page
    When I open the login page
    And I click the login button
    Then The login page loads

  Scenario: Try invalid login
    Given I am at the login page
    When I enter the following username and password
      | wrongun  |  wrongpw   |
    Then I see an error