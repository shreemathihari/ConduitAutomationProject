package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {

        this.driver = driver;
    }

    private By username =
            By.xpath("//input[@placeholder='Username']");

    private By email =
            By.xpath("//input[@placeholder='Email']");

    private By password =
            By.xpath("//input[@placeholder='Password']");
    private By signUpButton =
            By.xpath("//button[contains(text(),'Sign up')]");

    private By globalFeed =
            By.xpath("//*[contains(text(),'Global Feed')]");

    public void enterUsername(String userName) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement usernameField =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                username
                        )
                );

        usernameField.sendKeys(userName);
    }

    public void enterEmail(String emailId) {

        driver.findElement(email).sendKeys(emailId);
    }

    public void enterPassword(String pwd) {

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickSignUp() {

        driver.findElement(signUpButton).click();
    }

    public boolean isGlobalFeedDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(globalFeed)
        ).isDisplayed();
    }
}
