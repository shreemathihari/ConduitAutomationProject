Feature: Logout Functionality
Scenario: Successful Logout

Given the user is logged into application
When the user clicks Settings
And the user clicks Logout
Then logout should be successful