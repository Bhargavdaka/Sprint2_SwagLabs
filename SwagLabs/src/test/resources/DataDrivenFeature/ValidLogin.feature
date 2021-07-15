Feature: Login with valid credentials

  Scenario: Data Driven Login
    Given the user is on login screen
    When user enters username as a "standard_user"
    And user enters password as a "secret_sauce"
    And user clicks login button
    Then user should be on SwagLabs page

  Scenario Outline: Data Driven Login
    Given the user is on login screen
    When user enters username as a "<username>"
    And user enters password as a "<password>"
    And user clicks login button
    Then user should be on SwagLabs page

    Examples: 
      | username               | password     |
      | standard_user          | secret_sauce |
      | problem_user           | secret_sauce |
      | locked_out_user        | secret_sauce |
      | perfomance_glitch_user | secret_sauce |
