package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

/**
 * Created by DilshanF on 11/7/2018.
 */


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
@Test
public class SmokeTest extends AbstractTestNGCucumberTests{
}
