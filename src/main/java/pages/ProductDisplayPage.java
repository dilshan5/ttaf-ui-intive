package pages;

import com.automation.qa.ttafuicore.page.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import panels.AmazonHeaderPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class ProductDisplayPage extends BasicPage {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ProductDisplayPage.class));
    private WebDriverWait wait = new WebDriverWait(driver, 60);
    private AmazonHeaderPanel amazonHeaderPanel;
    private OfferListingPage offerListingPage;

    @FindBy(id = "add-to-cart-button")
    private WebElement add_to_cart_button;

    @FindBy(id = "buybox-see-all-buying-choices-announce")
    private WebElement buy_option_button;

    @FindBy(id = "twister_feature_div")
    private WebElement twister;

    @FindBy(id = "shelfSwatchSection-flavor_name")
    private WebElement twister_options;

    /**
     * Initialize ProductDisplayPage elements
     *
     * @param driver
     * @throws Exception
     */
    public ProductDisplayPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        //Initialize Elements
        PageFactory.initElements(driver, this);
        amazonHeaderPanel = new AmazonHeaderPanel(driver);
        offerListingPage = new OfferListingPage(driver);
    }

    public boolean verify_Current_Page() throws Exception {
        return driver.getCurrentUrl().toLowerCase().contains("/dp/");
    }

    public void add_item() throws Exception {
        try {
            click_add_cart_button();
        } catch (Exception Ex) {
            LOGGER.info("WARN: Add to cart button is not available for this product.");
        }
        try {
            //when there is no "Add to cart" button
            click_allBuying_options_button();
        } catch (Exception Ex) {
            LOGGER.info("WARN: Buying option is not available for this product.");
        }
        try {
            select_otherBuying_options();
        } catch (Exception Ex) {
            LOGGER.info("WARN: Twister options are not available for this product.");
        }
    }

    /**
     * Click on the Add to cart button
     *
     * @throws Exception
     */
    private void click_add_cart_button() throws Exception {
        if (add_to_cart_button.isDisplayed()) {
            add_to_cart_button.click();
            LOGGER.info("Info: Add the item to the Cart.");
        }
    }

    /**
     * Select All Other options available for thr Product and Add the Item
     *
     * @throws Exception
     */
    private void click_allBuying_options_button() throws Exception {
        if (buy_option_button.isDisplayed()) {   //when there is no "add to cart" button
            buy_option_button.click();
            LOGGER.info("Info: Check other buying options.");
            offerListingPage.add_to_cart_button();
            LOGGER.info("Info: Add the item to the Cart.");
        }
    }

    /**
     * Select Other options available for thr Product and Add the Item
     *
     * @throws Exception
     */
    private void select_otherBuying_options() throws Exception {
        if (twister.isDisplayed()) {
            //select an option from the list(flavours)
            List<WebElement> options = new ArrayList();
            options = twister_options.findElements(By.className("twisterShelf_swatch_text"));
            //change the selection until we can Add the product
            for (WebElement temp : options) {
                temp.click();
                LOGGER.info("Info: Checking other options...");
                //If "Add to Cart" button is available
                try {
                    click_add_cart_button();
                    break;
                } catch (Exception Ex) {
                    LOGGER.info("Info: Checking other options...");
                }
                //check if there a buying options available
                wait.until(ExpectedConditions.visibilityOf(buy_option_button));
                click_allBuying_options_button();
                break;
            }
        }
    }
}
