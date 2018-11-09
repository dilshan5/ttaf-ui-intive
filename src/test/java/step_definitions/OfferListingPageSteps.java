package step_definitions;

import com.automation.qa.ttafuicore.test.TestBase;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pages.OfferListingPage;
import pages.ProductDisplayPage;

import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class OfferListingPageSteps extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OfferListingPageSteps.class));
    OfferListingPage offerListingPage;

    @Then("^I should redirect to OfferListing page$")
    public void i_should_redirect_to_OfferListing_page() throws Throwable {
        offerListingPage = new OfferListingPage(getDriver());
        boolean pageType = offerListingPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Offer Listing Page");
    }

    @Then("^I click on \"([^\"]*)\" button on OfferListing page$")
    public void i_click_on_button_on_OfferListing_page(String arg1) throws Throwable {
        offerListingPage.add_to_cart_button();

    }
}
