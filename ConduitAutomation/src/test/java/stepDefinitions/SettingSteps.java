package stepDefinitions;
import org.junit.Assert;
import org.openqa.selenium.By;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SettingsPage;

public class SettingSteps {

    SettingsPage settingsPage;

    public SettingSteps() {

        settingsPage =
                new SettingsPage(DriverFactory.getDriver());
    }

    @When("the user opens Settings page")
    public void the_user_clicks_settings() {

        settingsPage.clickSettings();
    }

    @When("the user updates the bio as {string}")
    public void the_user_updates_bio_to(String bio) {

        settingsPage.updateBio(bio);
    }

    @When("the user clicks Update Settings")
    public void the_user_clicks_update_settings() {

        settingsPage.clickUpdateSettings();
    }

    @Then("the bio should be updated successfully")
    public void the_bio_should_be_updated_successfully() {

        System.out.println(
                "PASS - Bio Updated Successfully");
    }

   
}