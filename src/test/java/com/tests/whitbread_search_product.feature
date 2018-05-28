Feature: As a user i want to be able to search for a product on amazon home page and add it to basket

  Background:
      Given I am on amazon home page

    Scenario Outline: search for a product from the search menu and add it to the basket
      When I search for product "<product>" from the search menu
      And I add the product to the basket
      Then the product is added to the basket

    Examples:
              |product    |
              |Nike shoes |


