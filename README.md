# auto-awesome
Automation Test Repo

## Folders and Projects
- `allure/`: Legacy project
- `plexus/`: Plexus web page test project

## Setup and Execution
- To execute the Plexus tests, open the plexus project on Intellij and run all tests.
- Tests are executed over JUnit using Selenium

### Using Local Selenium
- You must put the path to the Gecko driver to your path environment variable prior to executing the tests
- You must add the following JVM param to your run configuration if you want test logging: `-Dlog4j.configurationFile=./target/test-classes/log4j-test.xml`
- Alternatively you can also run the maven test goal `mvn test`

### Using Containerized Selenium
- Run `docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-firefox:4.1.2-20220217`
- Add the following JVM param to yojr run configuration or test goal `-Dorg.wbombardellis.plexus.webdriver=http://localhost:4444`
