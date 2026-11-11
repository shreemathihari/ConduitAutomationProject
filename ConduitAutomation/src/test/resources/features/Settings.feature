Feature: Profile Functionality
Scenario: Update Bio

Given the user is logged into application
When the user opens Settings page
And the user updates the bio as "Automation Test Engineer"
And the user clicks Update Settings
Then the bio should be updated successfully