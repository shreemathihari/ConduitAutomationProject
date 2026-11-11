Feature: Article Functionality

  Scenario: Create Article

    Given the user is logged into application

    When the user clicks New Article

    And the user enters article title "Selenium Framework"

    And the user enters article description "POM Framework"

    And the user enters article body "This article is created using Selenium and Cucumber"

    And the user enters article tag "Automation"

    And the user clicks Publish Article

    Then the article should be created successfully
    Scenario: Edit Article

  Given the user is logged into application

  When the user clicks New Article

  And the user enters article title "Original Article"

  And the user enters article description "Original Description"

  And the user enters article body "Original Body"

  And the user enters article tag "Automation"

  And the user clicks Publish Article

  And the user clicks Edit Article

  And the user updates the article title to "Updated Article"

  And the user clicks Publish Article

  Then the article should be updated successfully
  Scenario: Delete Article

  Given the user is logged into application

  When the user clicks New Article

  And the user enters article title "Delete Test Article"

  And the user enters article description "Delete Description"

  And the user enters article body "Delete Body"

  And the user enters article tag "Automation"

  And the user clicks Publish Article

  And the user clicks Delete Article

  Then the article should be deleted successfully
  Scenario: Add Comment

 Given the user is logged into application
When the user clicks New Article
And the user enters article title "Comment Article"
And the user enters article description "Comment Description"
And the user enters article body "Comment Body"
And the user enters article tag "Automation"
And the user clicks Publish Article
Then the article should be created successfully

When the user enters comment "This is my first comment"
And the user clicks Post Comment
Then the comment should be displayed
Scenario: Delete Comment

Given the user is logged into application
When the user clicks New Article
And the user enters article title "Delete Comment Article"
And the user enters article description "Description"
And the user enters article body "Body"
And the user enters article tag "Automation"
And the user clicks Publish Article
And the user enters comment "Delete Me"
And the user clicks Post Comment
And the user deletes the comment
Then the comment should be removed

Scenario: Favorite Article

Given the user is logged into application
When the user favorites an article
Then the article should be favorited successfully

Scenario: Unfavorite Article

Given the user is logged into application
When the user favorites an article
And the user unfavorites the article
Then the article should be unfavorited successfully
