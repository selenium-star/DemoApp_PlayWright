package base;

import com.demoApp.LoginPage;
import com.demoApp.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Properties;

public class BaseTest {

    protected PlaywrightFactory playwrightFactory;
    protected Page page;
    LoginPage loginPage;
    protected Properties properties;

    @BeforeClass
    public void setUpBrowser() {
        System.out.println("BaseTest setup: Starting browser initialization.");
        playwrightFactory = new PlaywrightFactory();
        properties = playwrightFactory.initialiseProperties();
        page = playwrightFactory.initialiseBrowser(properties);
        System.out.println("BaseTest setup: Page object initialized: " + page);

        if (page == null) {
            throw new RuntimeException("Page object is null in BaseTest setup.");
        }

        loginPage = new LoginPage(page);
        loginPage.enterCredentials(properties.getProperty("username"), properties.getProperty("password"));
        if (page.locator("//h1[.='Web Application']").isVisible()) {
            System.out.println("Login is successful");
        }

    }

    @AfterClass
    public void tearDown() {
        if (page != null) {
            page.context().browser().close();
        }
    }
}
