package com.example.demo1.ui.common;

public enum MenuItem {
    SHOP("Shop", "shop"),
    ABOUT("About", "about"),
    RESOURCES("Resources", "resources");

    private final String menuText;
    private final String urlPart;
    MenuItem(String menuText, String urlPart) {
        this.urlPart = urlPart;
        this.menuText = menuText;
    }
    public String getMenuText(){
        return this.menuText;
    }
    public String getUrlPart(){
        return this.urlPart;
    }
}
