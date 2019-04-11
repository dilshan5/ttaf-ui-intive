package pages;

import com.automation.qa.ttafuicore.page.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import panels.AmazonHeaderPanel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class SearchResultsPage extends BasicPage {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SearchResultsPage.class));
    private AmazonHeaderPanel amazonHeaderPanel;
    private WebDriverWait wait = new WebDriverWait(driver, 100);

    @FindBy(id = "s-result-count")
    private WebElement search_keyword;

    @FindBy(id = "noResultsTitle")
    private WebElement zero_results_search_keyword;

    @FindBy(id = "s-results-list-atf")
    private WebElement products;

    @FindBy(id = "sort")
    private WebElement sort_drop_down;

    public SearchResultsPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        //Initialize Elements
        PageFactory.initElements(driver, this);
        amazonHeaderPanel = new AmazonHeaderPanel(driver);
    }

    public boolean verify_Current_Page() throws Exception {
        return driver.getCurrentUrl().toLowerCase().contains("&ref=");
    }

    public boolean verify_SearchResults_Keyword(String key) throws Exception {
        if (search_keyword.isDisplayed()) {
            return search_keyword.getText().toLowerCase().contains(key.toLowerCase());
        } else {
            LOGGER.log(Level.SEVERE, "Search Results are not Displayed");
            return false;
        }
    }

    public boolean verify_ZeroSearchResult_Title() throws Exception {
        if (zero_results_search_keyword.isDisplayed()) {
            return true;
        } else {
            LOGGER.log(Level.SEVERE, "Zero Search Result title is not Displayed");
            return false;
        }
    }

    /**
     * Select value from dropdown menu
     *
     * @param type
     * @throws Exception
     */
    public void sort_by_value(String type) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(sort_drop_down));
        Select dropdown = new Select(sort_drop_down);
        dropdown.selectByVisibleText(type);
    }

    /**
     * @return no of items display in the page
     */
    public int get_product_count() {
        return products.findElements(By.tagName("li")).size();
    }

    /**
     * @return no of items which have display the price values
     */
    public List<WebElement> get_productsBy_prices() {
        return products.findElements(By.className("sx-price-whole"));
    }

    /**
     * @return all products
     */
    public List<WebElement> get_AllProducts() {
        return products.findElements(By.className("s-result-item"));
    }

    public void click_on_any_product(int index) {
        wait.until(ExpectedConditions.visibilityOf(products));//wait until all the products are displayed
        products.findElements(By.className("s-result-item")).get(index).findElements(By.tagName("a")).get(0).click();
    }
}
