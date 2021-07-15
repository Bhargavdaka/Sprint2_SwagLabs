Feature: Login feature

  Scenario: Login with Valid credentials
    Given the user is on login screen
    When user enters valid username provided
    And user enters valid password provided
    And user clicks login button
    Then user should be on swaglabs page
    And user closes browser

  Scenario: login with invalid credentials
    Given the user is on login screen
    When user enters invalid username
    And user enters valid password
    And user clicks login button
    Then user should be on loginpage with error
    And user closes browser
