Feature: Login Functionality

  Scenario: Successful Login

    Given the user is on login page

    When the user enters login email

    And the user enters login password

    And the user clicks sign in button

    Then login should be successful
Scenario: Invalid Login

Given the user is on login page
When the user enters invalid email "invalid@test.com"
And the user enters invalid password "Wrong123"
And the user clicks sign in button
Then an error message should be displayed
    