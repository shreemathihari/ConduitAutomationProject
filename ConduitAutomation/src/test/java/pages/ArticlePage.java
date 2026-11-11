package pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePage {

    WebDriver driver;

    public ArticlePage(WebDriver driver) {

        this.driver = driver;
    }

    private By newArticle =
            By.xpath("//a[contains(@href,'/editor')]");

    private By articleTitle =
            By.cssSelector("input[placeholder='Article Title']");

    private By articleDescription =
            By.cssSelector("input[placeholder=\"What's this article about?\"]");

    private By articleBody =
            By.cssSelector("textarea[placeholder='Write your article (in markdown)']");

    private By articleTag =
            By.cssSelector("input[placeholder='Enter tags']");

    private By publishArticle =
            By.xpath("//button[contains(text(),'Publish Article')]");
    private By editArticle =
            By.xpath("//a[contains(text(),'Edit Article')]");
    private By deleteArticle =
            By.xpath("//button[contains(text(),'Delete Article')]");
    private By commentBox =
            By.xpath(
                    "//textarea[@placeholder='Write a comment...']"
            );
    private By postCommentButton =
            By.xpath("//button[contains(text(),'Post Comment')]");
    private By deleteComment =
            By.xpath("//span[@class='mod-options']//i[contains(@class,'ion-trash-a')]");
    By favoriteButton =
            By.xpath("//button[contains(@class,'btn-outline-primary')]");

    By unfavoriteButton =
            By.xpath("//button[contains(@class,'btn-primary')]");

    public void clickNewArticle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement articleBtn =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                newArticle
                        )
                );

        articleBtn.click();

        wait.until(
                ExpectedConditions.urlContains("/editor")
        );

        System.out.println(driver.getCurrentUrl());
    }

    public void enterTitle(String title) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement titleField =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                articleTitle
                        )
                );

        titleField.sendKeys(title);
    }

    public void enterDescription(String description) {

        driver.findElement(articleDescription).sendKeys(description);
    }

    public void enterBody(String body) {

        driver.findElement(articleBody).sendKeys(body);
    }

    public void enterTag(String tag) {

        driver.findElement(articleTag).sendKeys(tag);
    }

    public void clickPublishArticle() {

        driver.findElement(publishArticle).click();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(
                        ExpectedConditions.urlContains(
                                "/article/"
                        )
                );

        System.out.println(
                "After Publish = "
                + driver.getCurrentUrl()
        );
    }

    public boolean isArticlePublished(String title) {

        By publishedTitle =
                By.xpath("//h1[text()='" + title + "']");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        publishedTitle)
        ).isDisplayed();
    }
    public void clickEditArticle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(editArticle)
        ).click();
    }
    public void updateTitle(String newTitle) {

        driver.findElement(articleTitle).clear();

        driver.findElement(articleTitle).sendKeys(newTitle);
    }
    public boolean isUpdatedArticleDisplayed(String title) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions.urlContains("/article/")
        );
    }
    public void clickDeleteArticle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(deleteArticle)
        ).click();
    }
    public void enterComment(String comment) {

        System.out.println(
                "CURRENT URL = "
                + driver.getCurrentUrl()
        );

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        commentBox
                )
        );

        driver.findElement(commentBox).sendKeys(comment);
    }
  
    public void clickPostComment() {

        driver.findElement(postCommentButton).click();
    }
    public boolean isCommentDisplayed(String comment) {

        By commentText =
                By.xpath("//*[contains(text(),'" + comment + "')]");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(commentText)
        ).isDisplayed();
    }
    public void clickDeleteComment() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(deleteComment)
        );

        driver.findElement(deleteComment).click();
    }
    public void clickFavoriteArticle() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions
                .elementToBeClickable(favoriteButton))
                .click();
    }
    public boolean isArticleFavorited() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        unfavoriteButton
                )
        ).isDisplayed();
    }
    public void clickUnfavoriteArticle() {

    	WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions
                .elementToBeClickable(unfavoriteButton))
                .click();
    }
    public boolean isArticleUnfavorited() {

    	WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(favoriteButton))
                .isDisplayed();
    }
    
}