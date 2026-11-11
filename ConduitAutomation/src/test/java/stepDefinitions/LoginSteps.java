package stepDefinitions;
import factory.DriverFactory;
import utils.ConfigReader;
import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    private ConfigReader configReader =
            new ConfigReader();

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {

        driver = DriverFactory.getDriver();

        driver.get(
                configReader.getProperty("url") + "/login" );
        System.out.println("URL = " + driver.getCurrentUrl());
        System.out.println("TITLE = " + driver.getTitle());;

        loginPage = new LoginPage(driver);
    }

    @When("the user enters login email")
    public void the_user_enters_login_email() throws Exception {

        Thread.sleep(5000);

        loginPage.enterEmail(
                configReader.getProperty("username")
        );
    }

    @When("the user enters login password")
    public void the_user_enters_login_password() {

        loginPage.enterPassword(
                configReader.getProperty("password")
        );
    }

    @When("the user clicks sign in button")
    public void the_user_clicks_sign_in_button() {

        loginPage.clickSignIn();
    }

    @Then("login should be successful")
    public void login_should_be_successful() {

        Assert.assertTrue(
                loginPage.isGlobalFeedDisplayed()
        );
    	//Assert.assertTrue(false);
        System.out.println(
                "PASS - Login Successful"
        );
    }
    @When("the user enters invalid email {string}")
    public void the_user_enters_invalid_email(String email) {

        loginPage.enterEmail(email);
    }

    @And("the user enters invalid password {string}")
    public void the_user_enters_invalid_password(String password) {

        loginPage.enterPassword(password);
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {

        if (loginPage.isErrorMessageDisplayed()) {

            System.out.println(
                    "PASS - Invalid Login Validation Successful"
            );

        } else {

            throw new AssertionError(
                    "Error Message Not Displayed"
            );
        }
    }
    
}