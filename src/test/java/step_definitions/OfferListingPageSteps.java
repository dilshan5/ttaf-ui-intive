package step_definitions;

import com.automation.qa.ttafuicore.driver.DriverManager;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pages.OfferListingPage;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class OfferListingPageSteps {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OfferListingPageSteps.class));
    RemoteWebDriver driver = DriverManager.getDriver();
    OfferListingPage offerListingPage;

    @Then("^I should redirect to OfferListing page$")
    public void i_should_redirect_to_OfferListing_page() throws Throwable {
        Reporter.log("Then I should redirect to OfferListing page");
        offerListingPage = new OfferListingPage(driver);
        boolean pageType = offerListingPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Offer Listing Page");
    }

    @Then("^I click on \"([^\"]*)\" button on OfferListing page$")
    public void i_click_on_button_on_OfferListing_page(String arg1) throws Throwable {
        offerListingPage.add_to_cart_button();

    }
}
