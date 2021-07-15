Feature: Login

  Scenario: Data Driven Login
    Given the user is on login screen
    When user enters username as a "standard_user"
    And user enters password as a "secret_sauce"
    And user clicks login button
    Then user should be on SwagLabs page
 
 
    
