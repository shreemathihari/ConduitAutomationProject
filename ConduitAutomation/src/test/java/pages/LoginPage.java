package pages;
import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    private By email =
            By.name("email");
    private By password =
            By.name("password");
    private By signInButton =
            By.xpath("//button[contains(text(),'Sign in')]");

    private By globalFeed =
            By.xpath("//*[contains(text(),'Global Feed')]");
    By errorMessage =
            By.xpath("//ul[@class='error-messages']/li");

    public void enterEmail(String emailValue) {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement emailField =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//input[@placeholder='Email']")
                        ));

        emailField.clear();
        emailField.sendKeys(emailValue);
    }


    public void enterPassword(String pwd) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement passwordField =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//input[@placeholder='Password']")
                        ));

        passwordField.sendKeys(pwd);
    }

    public void clickSignIn() {

        driver.findElement(signInButton).click();
    }

    public boolean isGlobalFeedDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(globalFeed)
        ).isDisplayed();
    }
    public boolean isErrorMessageDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        errorMessage
                )
        ).isDisplayed();
    }
}
