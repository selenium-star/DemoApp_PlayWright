package com.demoApp;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

Playwright playwright;
Browser browser;
BrowserContext browserContext;
Page page;
Properties properties;

    public Page initialiseBrowser(Properties properties) {

        String browserName = properties.getProperty("browser").trim();

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            default:
                System.out.println("Please enter valid browser name");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(properties.getProperty("url").trim());

        return page;

    }

    public Properties initialiseProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/config.properties");
            properties = new Properties();
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

}
