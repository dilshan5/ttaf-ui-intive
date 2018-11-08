package step_definitions;

import com.trivago.qa.ttafuicore.test.TestBase;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pages.AmazonLoginPage;
import pages.OfferListingPage;

import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/8/2018.
 */
public class AmazonLoginPageSteps extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(AmazonLoginPageSteps.class));
    AmazonLoginPage amazonLoginPage;

    @Then("^I should be redirected to Login page$")
    public void i_should_be_redirected_to_page() throws Throwable {
        amazonLoginPage = new AmazonLoginPage(getDriver());
        boolean pageType = amazonLoginPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Login Page");
    }
}
