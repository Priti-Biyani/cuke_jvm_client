Feature: verify order online

  @javascript
  Scenario: verify order
    Given I visit the order status page
    Then I should see order delivered status

