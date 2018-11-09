package panels;

import com.automation.qa.ttafuicore.page.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class AmazonHeaderPanel extends BasicPage {
    private WebDriverWait wait = new WebDriverWait(driver, 100);
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = "input.nav-input")
    private WebElement searchIcon;

    @FindBy(css = "a#nav-cart.nav-a.nav-a-2")
    private WebElement addToCart;

    /**
     * Initialize AmazonHeaderPanel elements
     *
     * @param driver
     * @throws Exception
     */
    public AmazonHeaderPanel(WebDriver driver) throws Exception {
        super(driver);
        //Initialize Elements
        PageFactory.initElements(driver, this);
    }

    public void search_for(String keyword) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(keyword);
        wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        searchIcon.click();
    }

    public void click_Add_to_cart() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
    }
}
