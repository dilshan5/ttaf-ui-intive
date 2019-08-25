package step_definitions;

import com.automation.qa.ttafuicore.driver.DriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pages.AmazonHomePage;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class AmazonHomePageSteps {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(AmazonHomePageSteps.class));
    private AmazonHomePage amazonHomePage;
    private RemoteWebDriver driver = DriverManager.getDriver();

    @Given("^I visit the web site as a guest user$")
    public void i_visit_the_web_site_as_a_guest_user() throws Throwable {
        Reporter.log("Given I visit the web site as a guest user");
        amazonHomePage = new AmazonHomePage(driver);
        boolean pageTitle = amazonHomePage.check_HomePage_Page_Title();
        Assert.assertTrue(false, "Expected Title is Not Display");
        LOGGER.info("I am on Amazon Home page");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String key) throws Throwable {
        Reporter.log("And I search for '" + key + "' ");
        amazonHomePage.amazonHeaderPanel.search_for(key);
        LOGGER.info("Keyword searched :" + key + " ");
    }
}
