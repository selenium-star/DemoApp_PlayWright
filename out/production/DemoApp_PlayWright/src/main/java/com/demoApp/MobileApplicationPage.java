package com.demoApp;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;

public class MobileApplicationPage {

    private final Page page;

    public MobileApplicationPage(Page page) {
        this.page = page;
    }

    /**
     * Navigate to Mobile application page.
     */
    public void clickMobileApplication() {
        Locator button = page.locator("//button/h2[.='Mobile Application']");
        button.click();
    }

    /**
     * Get page title.
     * @return String
     */
    public String getPageTitle() {
        return page.locator("h1:text('Mobile Application')").textContent();
    }

    /**
     * Get all tickets.
     * @return List<String>
     */
    public List<String> getAllTickets() {
        List<String> tickets = page.locator("div.bg-white").allTextContents();
        return tickets;
    }

    /**
     * Get all columns.
     * @return List<String>
     */
    public List<String> getAllColumnsContent() {
        List<String> columnContent = page.locator("div.flex.flex-col").allTextContents();
        return columnContent;
    }

}
