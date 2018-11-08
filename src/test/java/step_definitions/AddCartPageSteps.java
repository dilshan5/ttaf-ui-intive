package step_definitions;

import com.trivago.qa.ttafuicore.test.TestBase;
import cucumber.api.java.en.When;
import pages.AddCartPage;

import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/8/2018.
 */
public class AddCartPageSteps extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(AddCartPageSteps.class));
    AddCartPage addCartPage;

    @When("^I click on \"([^\"]*)\" button on Cart page$")
    public void i_click_on_button_on_Cart_page(String arg1) throws Throwable {
        addCartPage = new AddCartPage(getDriver());
        addCartPage.amazonHeaderPanel.click_Add_to_cart();//click the Add to cart icon from the headerPanel
        LOGGER.info("I am on the Add to Cart Page");
        addCartPage.click_proceed_to_checkout();
        LOGGER.info("I clicked on the 'Proceed to checkout' button.");
    }
}
