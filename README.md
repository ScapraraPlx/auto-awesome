# auto-awesome

Automation Test Repo

## Features

- Automated browser tests using Selenium WebDriver
- TestNG as the test framework
- Allure for test reporting
- WebDriverManager for driver binaries management
- AssertJ for fluent assertions

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Running Tests

mvn clean test

## Generating Allure Report

1. Run tests to generate results:
   mvn clean test
2. Serve the Allure report:
   allure serve target/allure-results

## Project Structure

src/test/java   - Test sources  
pom.xml         - Maven configuration

## Dependencies

See pom.xml for the full list of dependencies and their versions.