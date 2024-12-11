package com.demoApp;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;

public class WebApplicationPage {

    private final Page page;

    public WebApplicationPage(Page page) {
        this.page = page;
    }

    /**
     * Get page title.
     * @return String
     */
    public String getPageTitle() {
        return page.locator("h1:text('Web Application')").textContent();
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
