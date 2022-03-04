# auto-awesome
Automation Test Repo

## Folders and Projects
- `allure/`: Legacy project
- `plexus/`: Plexus web page test project

## Setup and Execution
- To execute the Plexus tests, open the plexus project on Intellij and run all tests.
- Tests are executed over JUnit using Selenium
- You must put the path to the Gecko driver to your path environment variable prior to executing the tests
- You must add the following JVM param to your run configuration if you want test logging: `-Dlog4j.configurationFile=./target/test-classes/log4j-test.xml`
