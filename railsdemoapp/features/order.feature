Feature: place order online

  @javascript
  Scenario: place order
    Given I visit the order merchant site
    When I place an order
    Then order should get placed successfully
    
