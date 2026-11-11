Feature: User Registration
  Scenario: Successful Registration

    Given the user is on signup page

    When the user enters username "Shreema"

    And the user enters unique email

    And the user enters signup password "Test@12345"

    And the user clicks signup button

    Then registration should be successful