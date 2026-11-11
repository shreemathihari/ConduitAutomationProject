package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SettingsPage {

    WebDriver driver;
    WebDriverWait wait;

    By settingsLink = By.linkText("Settings");
    By logoutButton = By.xpath("//button[contains(text(),'Or click here to logout')]");
    private By bioTextArea = By.name("bio");
    @FindBy(xpath = "//button[contains(text(),'Update Settings')]")
    private WebElement updateSettingsButton;
    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(settingsLink)).click();
    }

    public void updateBio(String bio) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement bioField =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                bioTextArea
                        )
                );

        bioField.clear();
        bioField.sendKeys(bio);
    }

    public void clickUpdateSettings() {

        updateSettingsButton.click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}

