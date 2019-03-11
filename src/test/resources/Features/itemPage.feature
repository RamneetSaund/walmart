Feature: Validate Item Page

  Scenario: Validate contents of Item page
    Given customer is on home page
    When customer searches for 6000197495755
    And clicks on the search item number 6000197495755
    Then item page for 6000197495755 opens successfully
    And item page has title Play Day Deluxe Family Pool
    And item page has price $29.98

  Scenario: Validate contents of Item page that is available for online and in-store purchase
    Given customer is on home page
    When customer searches for 6000197495755
    And clicks on the search item number 6000197495755
    Then item page for 6000197495755 opens successfully
    And item page has buttons available for online purchase
    And item page has buttons available for in-store purchase

  Scenario: Validate contents of Item page that is available for online purchase only
    Given customer is on home page
    When customer searches for PRD260T4L4NE0X8
    And clicks on the search item number PRD260T4L4NE0X8
    Then item page for PRD260T4L4NE0X8 opens successfully
    And item page has buttons available for online purchase
    And item page doesnot have buttons available for in-store purchase

  Scenario: Validate contents of Item page that is available for in-store purchase only
    Given customer is on home page
    When customer searches for 933886
    And clicks on the search item number 933886
    Then item page for 933886 opens successfully
    And item page has buttons available for online purchase
    And item page doesnot have buttons available for in-store purchase

  Scenario: Validate contents of Item page that is neither available in-store nor for online purchase
    Given customer is on home page
    When customer searches for 6000197610834
    And clicks on the search item number 6000197610834
    Then item page for 6000197610834 opens successfully
    And item page doesnot have buttons available for online purchase
    And item page doesnot have buttons available for in-store purchase

  Scenario: Validate contents of Item page that has reduced price

  Scenario: Validate contents of Item page that is exclusive to Walmart

  Scenario: Validate contents of Item page that has only one picture

  Scenario: Validate contents of Item page that has more than one picture

  Scenario: Validate contents of Item page that is sold and shipped by Walmart

  Scenario: Validate contents of Item page that is sold and shipped by third-party

  Scenario: Validate contents of Item page that has no reviews

  Scenario: Validate contents of Item page that has reviews

  Scenario: Validate contents of Item page that has reviews

  Scenario: Validate contents of Item page that is eligible for free returns

  Scenario: Validate contents of Item page that has specific return policy

  Scenario: Validate contents of Pickup section of Item Page

  Scenario: Validate contents of Shipping section of Item Page

  Scenario: Validate contents of Q&A section of Item Page

  Scenario: Validate default contents of Find in-Store section of Item Page

  Scenario: Validate contents of Find in-Store section of Item Page when update postal code


