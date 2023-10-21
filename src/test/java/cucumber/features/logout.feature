Feature: Log out from application
  @Regression @Positive
  Scenario Outline: Logout Success
    Given user login with username "<username>"
    When user click logout button
    Then user in login page
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |