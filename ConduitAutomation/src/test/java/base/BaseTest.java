package base;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader configReader;

    public void setUp() {

        configReader = new ConfigReader();

        driver = DriverFactory.getDriver();
    }

    public void tearDown() {

        DriverFactory.quitDriver();
    }
}