Feature: Checkout Payment

  @Regression @Positive
  Scenario Outline: Checkout Success
    Given add several item using username "<username>"
    When user click checkout button
    And user fill the first name field
    And user fill the last name field
    And user fill the postal code field
    And user click continue checkout button
    And user click finish checkout button
    Then user in checkout complete page
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |

  @Regression @Negative
  Scenario Outline: Checkout Without fill the first name field
   Given add several item using username "<username>"
   When user click checkout button
   And user fill the last name field
   And user fill the postal code field
   And user click continue checkout button
   Then user see checkout error message "Error: First Name is required"
   Examples:
   |username               |
   |standard_user          |
   |problem_user           |
   |performance_glitch_user|
   |error_user             |
   |visual_user            |

  @Regression @Negative
  Scenario Outline: Checkout Without fill the last name field
    Given add several item using username "<username>"
    When user click checkout button
    And user fill the first name field
    And user fill the postal code field
    And user click continue checkout button
    Then user see checkout error message "Error: Last Name is required"
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |

  @Regression @Negative
  Scenario Outline: Checkout Without fill postal code field
    Given add several item using username "<username>"
    When user click checkout button
    And user fill the first name field
    And user fill the last name field
    And user click continue checkout button
    Then user see checkout error message "Error: Postal Code is required"
    Examples:
      |username               |
      |standard_user          |
      |problem_user           |
      |performance_glitch_user|
      |error_user             |
      |visual_user            |

  @Regression @Negative
  Scenario Outline: Checkout with fill not a number in postal code field
    Given add several item using username "<username>"
    When user click checkout button
    And user fill the first name field
    And user fill the last name field
    And user fill the postal code field With Not Number
    And user click continue checkout button
    Then user see checkout error message "Error: Postal Code must a number"
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |

  @Regression @Negative
  Scenario Outline: Checkout With fill Not Six Digit in postal code field
    Given add several item using username "<username>"
    When user click checkout button
    And user fill the first name field
    And user fill the last name field
    And user fill the postal code field With Not Six Digit
    And user click continue checkout button
    Then user see checkout error message "Error: Postal Code must have 6 Digit"
    Examples:
      |username               |
      |standard_user          |
      |problem_user           |
      |performance_glitch_user|
      |error_user             |
      |visual_user            |