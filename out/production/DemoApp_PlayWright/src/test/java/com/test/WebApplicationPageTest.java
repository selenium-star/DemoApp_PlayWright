package com.test;

import base.BaseTest;
import com.demoApp.WebApplicationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class WebApplicationPageTest extends BaseTest {
    WebApplicationPage webApplicationPage;

    @BeforeMethod
    public void setUpWebApplicationPage() {
        if (page == null) {
            throw new RuntimeException("Page object is null. Check BaseTest setup.");
        }
        webApplicationPage = new WebApplicationPage(page);
    }

    /**
     * Validate Web Application page.
     */
    @Test(priority = 1)
    public void validateTitle() {
        String title = webApplicationPage.getPageTitle();
        Assert.assertEquals(title, "Web Application");
    }


    /**
     * Validate Implement User authentication ticket and its tags
     */
    @Test(priority = 2)
    public void validateImplementTicket() {

        List<String> columnContent = webApplicationPage.getAllColumnsContent();
        boolean isColumnPresent = columnContent.stream().anyMatch(column -> column.contains("To Do"));
        boolean isTicketPresent = columnContent.stream().anyMatch(column -> column.contains("Implement user authentication"));
        Assert.assertTrue(isColumnPresent, "To Do column is not found");
        Assert.assertTrue(isTicketPresent, "Implement user authentication ticket is not present");

        List<String> tickets = webApplicationPage.getAllTickets();
        boolean isFeatureTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("Feature"));
        boolean isHighPriorityTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("High Priority"));
        Assert.assertTrue(isFeatureTagPresent, "Feature tag is not present");
        Assert.assertTrue(isHighPriorityTagPresent, "High priority tag is not present");
    }

    /**
     * Validate Fix Navigation ticket and its tag.
     */
    @Test(priority = 3)
    public void validateFixNavigationTicket() {

        List<String> columnContent = webApplicationPage.getAllColumnsContent();
        boolean isColumnPresent = columnContent.stream().anyMatch(column -> column.contains("To Do"));
        boolean isTicketPresent = columnContent.stream().anyMatch(column -> column.contains("Fix navigation bug"));
        Assert.assertTrue(isColumnPresent, "To Do column is not found");
        Assert.assertTrue(isTicketPresent, "Fix navigation bug ticket is not found");

        List<String> tickets = webApplicationPage.getAllTickets();
        boolean isBugTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("Bug"));
        Assert.assertTrue(isBugTagPresent, "Bug tag is not present");
    }

    /**
     * Validate Design System ticket and its tag.
     */
    @Test(priority = 4)
    public void validateDesignSystemTicket() {

        List<String> columnContent = webApplicationPage.getAllColumnsContent();
        boolean isColumnPresent = columnContent.stream().anyMatch(column -> column.contains("In Progress"));
        boolean isTicketPresent = columnContent.stream().anyMatch(column -> column.contains("Design system updates"));
        Assert.assertTrue(isColumnPresent, "In Progress column is not found");
        Assert.assertTrue(isTicketPresent, "Design system updates ticket is not found");

        List<String> tickets = webApplicationPage.getAllTickets();
        boolean isDesignTagPresent = tickets.stream().anyMatch(ticket -> ticket.contains("Design"));
        Assert.assertTrue(isDesignTagPresent, "Design tag is not present");
    }
}
