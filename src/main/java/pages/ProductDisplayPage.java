package pages;

import com.trivago.qa.ttafuicore.page.BasicPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import panels.AmazonHeaderPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class ProductDisplayPage extends BasicPage {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ProductDisplayPage.class));
    public AmazonHeaderPanel amazonHeaderPanel;
    public OfferListingPage offerListingPage;

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
    public ProductDisplayPage(WebDriver driver) throws Exception {
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
            //click on the add to cart button
            if (add_to_cart_button.isSelected()) {
                add_to_cart_button.click();
            }
        } catch (Exception Ex) {
            LOGGER.info("WARN: Add to cart button is not available for this product.");
        }
        try {
            if (buy_option_button.isDisplayed()) {   //when there is no "add to cart" button
                buy_option_button.click();
                offerListingPage.add_to_cart_button();
            }
        } catch (Exception Ex) {
            LOGGER.info("WARN: Buying option is not available for this product.");
        }
        try {
            if (twister.isDisplayed()) {
                //select an option from the list(flavours)
                List<WebElement> options = new ArrayList();
                options = twister_options.findElements(By.className("twisterShelf_swatch_text"));
                //change the selection until we can Add the product
                for (WebElement temp : options) {
                    temp.click();
                    //check if there a buying option
                    if (buy_option_button.isDisplayed()) {
                        buy_option_button.click();
                        offerListingPage.add_to_cart_button();
                        break;
                    }
                }
            }
        } catch (Exception Ex) {
            LOGGER.info("WARN: Twister options are not available for this product.");
        }
    }
}
