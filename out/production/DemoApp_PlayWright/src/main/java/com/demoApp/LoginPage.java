package com.demoApp;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    /**
     * Get page title.
     * @return String
     */
    public String getLoginPageTitle() {
        return page.title();
    }

    /**
     * Enter credentials.
     * @param username
     * @param password
     */
    public void enterCredentials(String username, String password) {
        String usernameField = "input[id='username']";
        page.fill(usernameField, username);
        String passwordField = "input[id='password']";
        page.fill(passwordField, password);
        String signInButton = "button[type='submit']";
        page.click(signInButton);
    }
}
