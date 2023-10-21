Feature: Log in to the application

  @Regression @Positive
  Scenario Outline: Login Success
    Given user open website in browser
    When input username "<username>"
    And input password "secret_sauce"
    And click login button
    Then user in dashboard page
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |

  @Regression @Negative
  Scenario Outline: Login Failed
    Given user open website in browser
    When input username "<username>"
    And input password "12345"
    And click login button
    Then user see error message "Epic sadface: Username and password do not match any user in this service"
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |

  Scenario: Login With Locked Out User
    Given user open website in browser
    When input username "locked_out_user"
    And input password "secret_sauce"
    And click login button
    Then user see error message "Epic sadface: Sorry, this user has been locked out."

  @Regression @Negative
  Scenario: Login Without Fill Username Field
    Given user open website in browser
    When input password "12345"
    And click login button
    Then user see error message "Epic sadface: Username is required"

  @Regression @Negative
  Scenario: Login With Without Password Field
    Given user open website in browser
    When input username "qwerty"
    And click login button
    Then user see error message "Epic sadface: Password is required"