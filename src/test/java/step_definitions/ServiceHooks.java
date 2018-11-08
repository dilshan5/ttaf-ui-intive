package step_definitions;

import com.trivago.qa.ttafuicore.test.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by DilshanF on 11/7/2018.
 */
public class ServiceHooks extends TestBase {
    @Before
    public void before() throws Exception {
        initializeBaseSetup();
    }

    @After
    public void after() throws Exception {
        tearDown();
    }
}
