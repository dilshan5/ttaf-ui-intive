package step_definitions;

import com.trivago.qa.ttafuicore.test.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.AmazonHomePage;

import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class AmazonHomePageSteps extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(AmazonHomePageSteps.class));
    AmazonHomePage amazonHomePage;

    @Given("^I visit the web site as a guest user$")
    public void i_visit_the_web_site_as_a_guest_user() throws Throwable {
        amazonHomePage = new AmazonHomePage(getDriver());
        boolean pageTitle = amazonHomePage.check_HomePage_Page_Title();
        Assert.assertTrue(pageTitle, "Expected Title is Not Display");
        LOGGER.info("I am on Amazon Home page");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String key) throws Throwable {
        amazonHomePage.amazonHeaderPanel.search_for(key);
        LOGGER.info("Keyword searched :" + key + " ");
    }
}
