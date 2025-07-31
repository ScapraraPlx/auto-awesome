package com.example.demo1.ui.common;

import com.example.demo1.ui.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.example.demo1.ui.utils.ConfigReader.getImplicitWait;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String SELENOID_URL = ConfigReader.get("selenoidUrl");
    private static final String BROWSER = ConfigReader.get("browser");

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriver initDriver() {
        String browser = ConfigReader.get("browser");
        boolean isRemote = Boolean.parseBoolean(ConfigReader.get("is_remote"));
        if (browser == null) browser = "chrome";

        if (isRemote) {
            URL url;
            try {
                url = new URL(SELENOID_URL);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.set(new RemoteWebDriver(url, getOptions()));
            driver.get().manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
            driver.get().manage().window().maximize();
            return driver.get();
        } else {
            WebDriver webDriver;
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(getOptions());
                    break;
            }
            driver.set(webDriver);
            driver.get().manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
            driver.get().manage().window().maximize();
            return driver.get();
        }
    }

    private static ChromeOptions getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", BROWSER);
        return chromeOptions;
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
