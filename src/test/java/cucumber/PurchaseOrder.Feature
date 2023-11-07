
@tag
Feature: Purchase the order from Ecommerce
  I want to use this template for my feature file

Background: I landed on Ecommerce Page
		Given I landed on Ecommerce Page

  @tag1
  Scenario Outline: Positive test of Submiting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from Cart
    And Checkout <productName> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation Page

    Examples: 
      | name                | password   | productName |
      | ishaq8283@gmail.com | Test 123   | ZARA COAT 3 |