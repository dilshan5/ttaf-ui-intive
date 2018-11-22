package step_definitions;

import com.automation.qa.ttafuicore.driver.DriverManager;
import com.automation.qa.ttafuicore.util.Constant;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class ServiceHooks {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ServiceHooks.class));

    @After
    public void after(Scenario scenario) throws Exception {
        RemoteWebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            Constant.SCENARIO_NAME = scenario.getName(); //set the scenario name to create a node in Reporter
            driver.quit();
            LOGGER.info("TTAF MESSAGE: Closing the " + Constant.BROWSER_NAME + " browser...");
        }
    }
}
