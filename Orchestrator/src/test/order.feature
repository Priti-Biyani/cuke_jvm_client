Feature: Place Order Online

Scenario: place order
    Given I visit the order merchant site and I place the order
    When order is fulfilled
    Then I see the delivered status at Merchant site



