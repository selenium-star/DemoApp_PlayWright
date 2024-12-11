package com.test;

import base.BaseTest;
import com.demoApp.MobileApplicationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class MobileApplicationPageTest extends BaseTest {

    MobileApplicationPage mobileApplicationPage;

    @BeforeMethod
    public void setUpWebApplicationPage() {
        if (page == null) {
            throw new RuntimeException("Page object is null. Check BaseTest setup.");
        }
        mobileApplicationPage = new MobileApplicationPage(page);
        mobileApplicationPage.clickMobileApplication();
    }

    /**
     * Validate Mobile Application page.
     */
    @Test(priority = 1)
    public void validateTitle() {
        String title = mobileApplicationPage.getPageTitle();
        Assert.assertEquals(title, "Mobile Application");
    }

    /**
     * Validate Push notification system ticket and its tag.
     */
    @Test(priority = 2)
    public void validatePushNotificationTicket() {

        List<String> columnContent = mobileApplicationPage.getAllColumnsContent();
        boolean isColumnPresent = columnContent.stream().anyMatch(column -> column.contains("To Do"));
        boolean isTicketPresent = columnContent.stream().anyMatch(column -> column.contains("Push notification system"));
        Assert.assertTrue(isColumnPresent, "To Do column is not found");
        Assert.assertTrue(isTicketPresent, "Push notification system ticket is not present");


        List<String> tickets = mobileApplicationPage.getAllTickets();
        boolean isFeatureTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("Feature"));
        Assert.assertTrue(isFeatureTagPresent, "Feature tag is not present");
    }

    /**
     * Validate Offline mode ticket and its tag.
     */
    @Test(priority = 3)
    public void validateOfflineModeTicket() {

        List<String> columnContent = mobileApplicationPage.getAllColumnsContent();
        boolean isColumnPresent = columnContent.stream().anyMatch(column -> column.contains("In Progress"));
        boolean isTicketPresent = columnContent.stream().anyMatch(column -> column.contains("Offline mode"));
        Assert.assertTrue(isColumnPresent, "In Progress column is not found");
        Assert.assertTrue(isTicketPresent, "Push notification system ticket is not found");


        List<String> tickets = mobileApplicationPage.getAllTickets();
        boolean isFeatureTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("Feature"));
        boolean isHighPriorityTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("High Priority"));
        Assert.assertTrue(isFeatureTagPresent, "Feature tag is not present");
        Assert.assertTrue(isHighPriorityTagPresent, "High Priority tag is not present");
    }

    /**
     * Validate App icon ticket and its tag.
     */
    @Test(priority = 4)
    public void validateAppIconTicket() {

        List<String> columnContent = mobileApplicationPage.getAllColumnsContent();
        boolean isColumnPresent = columnContent.stream().anyMatch(column -> column.contains("Done"));
        boolean isTicketPresent = columnContent.stream().anyMatch(column -> column.contains("App icon design"));
        Assert.assertTrue(isColumnPresent, "Done column is not found");
        Assert.assertTrue(isTicketPresent, "App icon design ticket is not found");

        List<String> tickets = mobileApplicationPage.getAllTickets();
        boolean isDesignTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("Design"));
        Assert.assertTrue(isDesignTagPresent, "Design tag is not present");
    }
}
