package hooks;
import com.aventstack.extentreports.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utils.ExtentManager;

public class ExtentHooks {

    private static ExtentReports extent =
            ExtentManager.getInstance();

    private static ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {

        test = extent.createTest(
                scenario.getName()
        );
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {

            test.fail("Scenario Failed");

        } else {

            test.pass("Scenario Passed");
        }

        extent.flush();
    }
}