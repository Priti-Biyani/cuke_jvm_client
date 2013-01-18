Feature: Place Order Online

Scenario: place order
    Given I visit the order merchant site and I place the order
    When I change the status from play
    Then order status is changed at merchant site



