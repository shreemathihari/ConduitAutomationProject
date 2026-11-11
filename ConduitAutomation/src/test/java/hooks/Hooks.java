/*package hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.BaseTest;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before
    public void beforeScenario() {

        System.out.println("Before Scenario Running");

        setUp();
    }
    @After
    public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
    byte[] screenshot = ((TakesScreenshot)
    DriverFactory.getDriver())
    .getScreenshotAs(OutputType.BYTES);
    scenario.attach(
    screenshot,
    "image/png",
    scenario.getName()
    );
    System.out.println(
    "Screenshot captured for failed scenario"
    );
    }
    DriverFactory.quitDriver();
    System.out.println("After Scenario Running");
    }

    @After
    public void afterScenario() {

        System.out.println("After Scenario Running");

        tearDown();
    }
    
}*/
package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setUp() {

        System.out.println(
                "Before Scenario Running"
        );

        DriverFactory.initializeDriver();
    }

    @After
    public void tearDown(
            Scenario scenario) {

        if (scenario.isFailed()) {

            ScreenshotUtil.captureScreenshot(
                    DriverFactory.getDriver(),
                    scenario.getName()
            );

            System.out.println(
                    "Screenshot captured for failed scenario"
            );
        }

        DriverFactory.quitDriver();

        System.out.println(
                "After Scenario Running"
        );
    }
}