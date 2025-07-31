package com.example.demo1.listeners;

import com.example.demo1.driver.DriverManager;
import com.example.demo1.utils.ScreenshotHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotHelper.takeScreenshot(DriverManager.getDriver());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ScreenshotHelper.takeScreenshot(DriverManager.getDriver());
    }
}