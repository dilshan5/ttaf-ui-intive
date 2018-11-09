package step_definitions;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import com.automation.qa.ttafuicore.test.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AmazonHomePage;
import pages.ProductDisplayPage;
import pages.SearchResultsPage;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class SearchResultsPageSteps extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SearchResultsPageSteps.class));
    SearchResultsPage searchResultsPage;
    AmazonHomePage amazonHomePage;
    ProductDisplayPage productDisplayPage;

    @Then("^I should be in Search Result page$")
    public void i_should_be_in_page() throws Throwable {
        searchResultsPage = new SearchResultsPage(getDriver());
        boolean pageType = searchResultsPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Search Result page");
    }

    @Then("^I verify the Sort By \"([^\"]*)\" functionality$")
    public void i_verify_the_Sort_By_functionality(String sort_by) throws Throwable {
        //  int old_product_countBy_prices = searchResultsPage.get_product_countBy_prices();
        searchResultsPage.sort_by_value(sort_by);
        //   int new_product_countBy_prices = searchResultsPage.get_product_countBy_prices();
        //  boolean isProductAssort = (old_product_countBy_prices != new_product_countBy_prices) ? true : false;
        //   Assert.assertTrue(isProductAssort, "Product list is sorted by ");
        LOGGER.info("Product list is sorted by: " + sort_by);
    }

    @Then("^Page should have search keyword as \"([^\"]*)\"$")
    public void page_should_have_search_keyword_as(String searchKey) throws Throwable {
        boolean keyWord = searchResultsPage.verify_SearchResults_Keyword(searchKey);
        Assert.assertTrue(keyWord, "Expected keyWord is Not Found");
        LOGGER.info("I verified the Search keyword");
        searchResultsPage.get_product_count();
    }

    @Then("^I should be in \"([^\"]*)\" page$")
    public void i_should_be_in_page(String arg1) throws Throwable {
        searchResultsPage = new SearchResultsPage(getDriver());
        boolean keyWord = searchResultsPage.verify_ZeroSearchResult_Title();
        Assert.assertTrue(keyWord, "Zero result message is Not Found");
        LOGGER.info("I verified the Zero Search result");
    }

    @When("^I click on \"([^\"]*)\" Product Thumbnail in search results page$")
    public void i_click_on_Product_Thumbnail_in_search_results_page(String step) throws Throwable {
        switch (step) {
            case "first":
                searchResultsPage.click_on_any_product(0);
                break;
        }
        LOGGER.info("I clicked on " + step + " Item");
    }


    @When("^I search for following Candies and ADD the cheapest candy of each$")
    public void i_search_for_following_Candies_and_ADD_the_cheapest_candy_of_each(DataTable candy) throws Throwable {
        //Write the code to handle Data Table
        List<List<String>> list = candy.asLists(String.class);
        amazonHomePage = new AmazonHomePage(getDriver());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0));
            amazonHomePage.amazonHeaderPanel.search_for(list.get(i).get(0));
            i_should_be_in_page();
            i_verify_the_Sort_By_functionality("Price: Low to High");
            i_click_on_Product_Thumbnail_in_search_results_page("first");
            productDisplayPage = new ProductDisplayPage(getDriver());
            productDisplayPage.verify_Current_Page();
            productDisplayPage.add_item();
        }

    }
}
