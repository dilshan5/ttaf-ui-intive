package step_definitions;

import com.automation.qa.ttafuicore.driver.DriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pages.AmazonHomePage;
import pages.ProductDisplayPage;
import pages.SearchResultsPage;

import java.util.List;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class SearchResultsPageSteps {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SearchResultsPageSteps.class));
    RemoteWebDriver driver = DriverManager.getDriver();
    SearchResultsPage searchResultsPage;
    AmazonHomePage amazonHomePage;
    ProductDisplayPage productDisplayPage;

    @Then("^I should be in Search Result page$")
    public void i_should_be_in_page() throws Throwable {
        Reporter.log("Then I should be in Search Result page");
        searchResultsPage = new SearchResultsPage(driver);
        boolean pageType = searchResultsPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Search Result page");
    }

    @Then("^I verify the Sort By \"([^\"]*)\" functionality$")
    public void i_verify_the_Sort_By_functionality(String sort_by) throws Throwable {
        Reporter.log("And I verify the Sort By '" + sort_by + "' functionality");
        //  int old_product_countBy_prices = searchResultsPage.get_product_countBy_prices();
        searchResultsPage.sort_by_value(sort_by);
        //   int new_product_countBy_prices = searchResultsPage.get_product_countBy_prices();
        //  boolean isProductAssort = (old_product_countBy_prices != new_product_countBy_prices) ? true : false;
        //   Assert.assertTrue(isProductAssort, "Product list is sorted by ");
        LOGGER.info("Product list is sorted by: " + sort_by);
    }

    @Then("^Page should have search keyword as \"([^\"]*)\"$")
    public void page_should_have_search_keyword_as(String searchKey) throws Throwable {
        Reporter.log("And Page should have search keyword as '" + searchKey + "'");
        boolean keyWord = searchResultsPage.verify_SearchResults_Keyword(searchKey);
        Assert.assertTrue(keyWord, "Expected keyWord is Not Found");
        LOGGER.info("I verified the Search keyword");
        searchResultsPage.get_product_count();
    }

    @Then("^I should be in \"([^\"]*)\" page$")
    public void i_should_be_in_page(String arg1) throws Throwable {
        Reporter.log("Then I should be in '" + arg1 + "' page");
        searchResultsPage = new SearchResultsPage(driver);
        boolean keyWord = searchResultsPage.verify_ZeroSearchResult_Title();
        Assert.assertTrue(keyWord, "Zero result message is Not Found");
        LOGGER.info("I verified the Zero Search result");
    }

    @When("^I click on \"([^\"]*)\" Product Thumbnail in search results page$")
    public void i_click_on_Product_Thumbnail_in_search_results_page(String step) throws Throwable {
        Reporter.log("And I click on '" + step + "' Product Thumbnail in search results page");
        switch (step) {
            case "first":
                searchResultsPage.click_on_any_product(0);
                break;
        }
        productDisplayPage = new ProductDisplayPage(driver);
        //If there are 'Shop by Category' is available for the searchKey
        if (!(productDisplayPage.verify_Current_Page())) {
            searchResultsPage.click_on_any_product(0);
        }
        LOGGER.info("I clicked on " + step + " Item");
    }


    @When("^I search for following Candies and ADD the cheapest candy of each$")
    public void i_search_for_following_Candies_and_ADD_the_cheapest_candy_of_each(DataTable candy) throws Throwable {
        Reporter.log("When I search for following Candies and ADD the cheapest candy of each");
        List<List<String>> list = candy.asLists(String.class);
        amazonHomePage = new AmazonHomePage(driver);

        //Write the code to handle Data Table
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0));
            amazonHomePage.amazonHeaderPanel.search_for(list.get(i).get(0));
            i_should_be_in_page();//verify user is on "Search Result" page
            i_verify_the_Sort_By_functionality("Price: Low to High");//sort the search results
            i_click_on_Product_Thumbnail_in_search_results_page("first");//click on the Nth item
            productDisplayPage.verify_Current_Page();
            productDisplayPage.add_item();//add the item to Cart
        }

    }
}
