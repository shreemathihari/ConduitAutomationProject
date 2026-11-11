package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SettingsPage;

public class LogoutSteps {

    WebDriver driver;
    SettingsPage settingsPage;

    public LogoutSteps() {
        driver = DriverFactory.getDriver();
        settingsPage = new SettingsPage(driver);
    }

    @When("the user clicks Settings")
    public void the_user_clicks_settings() {
        settingsPage.clickSettings();
    }

    @And("the user clicks Logout")
    public void the_user_clicks_logout() {
        settingsPage.clickLogout();
    }

    @Then("logout should be successful")
    public void logout_should_be_successful() {

        Assert.assertTrue(
                driver.findElement(By.linkText("Sign in")).isDisplayed()
        );

        System.out.println("PASS - Logout Successful");
    }
}

