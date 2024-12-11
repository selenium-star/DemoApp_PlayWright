package com.test;

import base.BaseTest;
import com.demoApp.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUpLoginPage() {
        if (page == null) {
            throw new RuntimeException("Page object is null. Check BaseTest setup.");
        }
        loginPage = new LoginPage(page);
    }

    /**
     * Validate Login page title.
     */
    @Test
    public void validateTitle() {
        String pageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(pageTitle, "Vite + React + TS");
    }
}
