package stepDefinitions;

import org.junit.Assert;

import base.BaseTest;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.ArticlePage;
import pages.LoginPage;
import utils.ConfigReader;

public class ArticleSteps extends BaseTest {

    LoginPage loginPage;
    ArticlePage articlePage;

    private ConfigReader configReader =
            new ConfigReader();

    private String articleTitle;
    private String updatedTitle;
    private String commentText;

    @Given("the user is logged into application")
    public void the_user_is_logged_into_application() {

        driver = DriverFactory.getDriver();

        driver.get(
                configReader.getProperty("url") + "/login"
        );

        loginPage = new LoginPage(driver);

        loginPage.enterEmail(
                configReader.getProperty("username")
        );

        loginPage.enterPassword(
                configReader.getProperty("password")
        );

        loginPage.clickSignIn();

        articlePage = new ArticlePage(driver);
    }

    @When("the user clicks New Article")
    public void the_user_clicks_new_article() {

        articlePage.clickNewArticle();
    }

    @When("the user enters article title {string}")
    public void the_user_enters_article_title(String title) {

        articleTitle = title;

        articlePage.enterTitle(title);
    }

    @When("the user enters article description {string}")
    public void the_user_enters_article_description(String description) {

        articlePage.enterDescription(description);
    }

    @When("the user enters article body {string}")
    public void the_user_enters_article_body(String body) {

        articlePage.enterBody(body);
    }

    @When("the user enters article tag {string}")
    public void the_user_enters_article_tag(String tag) {

        articlePage.enterTag(tag);
    }

    @When("the user clicks Publish Article")
    public void the_user_clicks_publish_article() {

        articlePage.clickPublishArticle();
    }

    @Then("the article should be created successfully")
    public void the_article_should_be_created_successfully() {

        Assert.assertTrue(
                articlePage.isArticlePublished(articleTitle)
        );

        System.out.println(
                "PASS - Article Created Successfully"
        );
    }
    @Given("the user opens an existing article")
    public void the_user_opens_an_existing_article() {

        driver.get(
            configReader.getProperty("url")
            + "/article/some-existing-article"
        );
    }

    @When("the user clicks Edit Article")
    public void the_user_clicks_edit_article() {

        System.out.println("Before Edit: " + driver.getCurrentUrl());

        articlePage.clickEditArticle();

        System.out.println("After Edit: " + driver.getCurrentUrl());
    }

    @When("the user updates the article title to {string}")
    public void the_user_updates_the_article_title_to(String title) {

        updatedTitle =
                title + System.currentTimeMillis();

        articlePage.updateTitle(updatedTitle);
    }

    @Then("the article should be updated successfully")
    public void the_article_should_be_updated_successfully() {

        Assert.assertTrue(
                articlePage.isUpdatedArticleDisplayed(updatedTitle)
        );

        System.out.println(
                "PASS - Article Updated Successfully"
        );
    }

    @When("the user clicks Delete Article")
    public void the_user_clicks_delete_article() {

        articlePage.clickDeleteArticle();
    }

    @Then("the article should be deleted successfully")
    public void the_article_should_be_deleted_successfully() {

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("demo.realworld.show")
        );

        System.out.println(
                "PASS - Article Deleted Successfully"
        );
    }

    @When("the user enters comment {string}")
    public void the_user_enters_comment(String comment) {

        commentText = comment;

        articlePage.enterComment(comment);
    }

    @When("the user clicks Post Comment")
    public void the_user_clicks_post_comment() {

        articlePage.clickPostComment();
    }

    @Then("the comment should be displayed")
    public void the_comment_should_be_displayed() {

        Assert.assertTrue(
                articlePage.isCommentDisplayed(commentText)
        );

        System.out.println(
                "PASS - Comment Added Successfully"
        );
    }
    @When("the user deletes the comment")
    public void the_user_deletes_the_comment() {

        articlePage.clickDeleteComment();
    }

    @Then("the comment should be removed")
    public void the_comment_should_be_removed() {

        Assert.assertFalse(
                driver.getPageSource()
                        .contains("This is my first comment")
        );

        System.out.println(
                "PASS - Comment Deleted Successfully"
        );
    }
    @When("the user favorites an article")
    public void the_user_favorites_an_article() {

        articlePage.clickFavoriteArticle();
    }
    @Then("the article should be favorited successfully")
    public void the_article_should_be_favorited_successfully() {

        Assert.assertTrue(
                articlePage.isArticleFavorited()
        );

        System.out.println(
                "PASS - Article Favorited Successfully"
        );
    }

    @When("the user unfavorites the article")
    public void the_user_unfavorites_the_article() {

        articlePage.clickUnfavoriteArticle();
    }

    @Then("the article should be unfavorited successfully")
    public void the_article_should_be_unfavorited_successfully() {

        Assert.assertTrue(
                articlePage.isArticleUnfavorited()
        );

        System.out.println(
                "PASS - Article Unfavorited Successfully"
        );
    }
}
