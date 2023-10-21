Feature: Cart Item

  @Regression @Positive
  Scenario Outline: User Add Item to Cart Success
    Given user login to dashboard with "<username>"
    And click add to cart button for item "<item_id>"
    Then User see cart icon with number 1
    Examples:
    |item_id                                      |
    |add-to-cart-sauce-labs-backpack              |
    |add-to-cart-sauce-labs-bike-light            |
    |add-to-cart-sauce-labs-bolt-t-shirt          |
    |add-to-cart-sauce-labs-fleece-jacket         |
    |add-to-cart-sauce-labs-onesie                |
    |add-to-cart-test.allthethings()-t-shirt-(red)|
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |

  @Regression @Positive
  Scenario Outline: User Remove Item From Cart From Cart Page Success
    Given user login to dashboard with "<username>"
    And click all add to cart item in dashboard page
    And user click cart icon
    And click all remove item in cart page
    Then User see no items in cart item
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |

  @Regression @Positive
  Scenario Outline: User Remove Item From Dashboard From Cart Page Success
    Given user login to dashboard with "<username>"
    And click all add to cart item in dashboard page
    And click all remove item in dashboard page
    And user click cart icon
    Then User see no items in cart item
    Examples:
    |username               |
    |standard_user          |
    |problem_user           |
    |performance_glitch_user|
    |error_user             |
    |visual_user            |