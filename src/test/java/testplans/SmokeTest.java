package testplans;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by DilshanF on 11/7/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step_definitions"},
        format = {
                "pretty",
                "json:target/cucumber-reports/smokeTestResults.json",
                "html:target/cucumber-reports"
        },
        monochrome = false,
        tags = {"@smoke", "~@wip"}
)
public class SmokeTest {
}
