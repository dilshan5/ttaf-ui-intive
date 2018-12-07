package step_definitions;

import com.automation.qa.ttafuicore.driver.DriverManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pages.ProductDisplayPage;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class ProductDisplayPageSteps {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ProductDisplayPageSteps.class));
    private ProductDisplayPage productDisplayPage;
    private RemoteWebDriver driver = DriverManager.getDriver();

    @Then("^I should redirect to PDP page$")
    public void i_should_redirect_to_PDP_page() throws Throwable {
        Reporter.log("Then I should redirect to PDP page");
        productDisplayPage = new ProductDisplayPage(driver);
        boolean pageType = productDisplayPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Product Display Page");
    }

    @Given("^I click Add to cart button$")
    public void i_click_Add_to_cart_button() throws Throwable {
        Reporter.log("And I click Add to cart button");
        productDisplayPage.add_item();
    }

}
