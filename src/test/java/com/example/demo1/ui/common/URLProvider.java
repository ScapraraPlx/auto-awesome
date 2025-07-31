package com.example.demo1.ui.common;

import com.example.demo1.ui.utils.ConfigReader;

public class URLProvider {

    public static String getBaseURL() {
        return ConfigReader.getBaseURL();
    }

    public static String getMenuURL(MenuItem menuItem) {
        return ConfigReader.getBaseURL() + menuItem.getUrlPart();
    }
}
