package stepDefinitions;
import factory.DriverFactory;
import utils.ConfigReader;
import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.*;

import pages.SignUpPage;

public class SignUpSteps extends BaseTest {

    SignUpPage signUpPage;
    private ConfigReader configReader =
            new ConfigReader();
    String uniqueEmail;

    @Given("the user is on signup page")
    public void the_user_is_on_signup_page() {

        driver = DriverFactory.getDriver();

        driver.get(
                configReader.getProperty("url") + "/register"
        );

        signUpPage = new SignUpPage(driver);
    }

    @When("the user enters username {string}")
    public void the_user_enters_username(String username) {

        signUpPage.enterUsername(username);
    }

    @When("the user enters unique email")
    public void the_user_enters_unique_email() {

        uniqueEmail =
                "user" + System.currentTimeMillis()
                        + "@gmail.com";

        signUpPage.enterEmail(uniqueEmail);
    }

    @When("the user enters signup password {string}")
    public void the_user_enters_signup_password(String password) {

        signUpPage.enterPassword(password);
    }

    @When("the user clicks signup button")
    public void the_user_clicks_signup_button() {

        signUpPage.clickSignUp();
    }

    @Then("registration should be successful")
    public void registration_should_be_successful() {

        Assert.assertTrue(
                signUpPage.isGlobalFeedDisplayed()
        );

        System.out.println(
                "PASS - Registration Successful"
        );
    }
}