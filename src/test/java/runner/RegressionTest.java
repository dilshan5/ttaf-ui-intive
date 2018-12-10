package runner;

import com.automation.qa.ttafuicore.util.CustomAbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;

/**
 * Created by DilshanF on 11/10/2018.
 */
@CucumberOptions(
        dryRun = false,//Skip execution of glue code.
        strict = true,// Treat undefined and pending steps as errors.
        features = "src/test/resources/features",
        glue = {"step_definitions"},
        plugin = {
                "pretty",
                "json:target/cucumber-reports/regressionTestResults.json",
                "html:target/cucumber-reports"
        },
        monochrome = false,//Don't colour terminal output.
        tags = {"@regression"}
)
@Test
public class RegressionTest extends CustomAbstractTestNGCucumberTests {
}

