package pages;

import com.automation.qa.ttafuicore.page.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import panels.AmazonHeaderPanel;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class AmazonHomePage extends BasicPage {

    public AmazonHeaderPanel amazonHeaderPanel;

    /**
     * Initialize AmazonHomePage elements
     *
     * @param driver
     * @throws Exception
     */
    public AmazonHomePage(WebDriver driver) throws Exception {
        super(driver);
        //Initialize Elements
        PageFactory.initElements(driver, this);
        amazonHeaderPanel = new AmazonHeaderPanel(driver);
    }

    public boolean check_HomePage_Page_Title() throws Exception {
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        return driver.getTitle().equals(expectedTitle);
    }

}
