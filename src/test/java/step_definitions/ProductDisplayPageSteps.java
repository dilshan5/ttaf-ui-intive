package step_definitions;

import com.automation.qa.ttafuicore.test.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.ProductDisplayPage;

import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class ProductDisplayPageSteps extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ProductDisplayPageSteps.class));
    ProductDisplayPage productDisplayPage;

    @Then("^I should redirect to PDP page$")
    public void i_should_redirect_to_PDP_page() throws Throwable {
        productDisplayPage = new ProductDisplayPage(getDriver());
        boolean pageType = productDisplayPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Product Display Page");
    }

    @Given("^I click Add to cart button$")
    public void i_click_Add_to_cart_button() throws Throwable {
        productDisplayPage.add_item();
    }

}
