Feature: As a user i want to be able to search for a propety to rent in zoopla web site and validate the searching views

  Background:
      Given I am on zoopla home page

    Scenario: search for property in portsmouth and validate the different search views
      When I navigate to the rent property section
      And I search for a property in "Portsmouth" with minimum price "£500 pcm" maximum price "£2,000 pcm"  and type "Flats"
      Then rental type is correct "rent"
      Then view type "List view" is enabled
      Then view type "Grid view" is disabled
      Then view type "Map view" is disabled
      When I select view "Grid view"
      Then view type "Grid view" is enabled
      Then view type "List view" is disabled
      Then view type "Map view" is disabled

  Scenario: search for property in Portsmouth with default values and validate the different search views
    When I navigate to the rent property section
    And I search for a property in "Portsmouth" with minimum price "No min" maximum price "No max"  and type "Show all"
    Then rental type is correct "rent"
    Then view type "List view" is enabled
    Then view type "Grid view" is disabled
    Then view type "Map view" is disabled
    When I select view "Grid view"
    Then view type "Grid view" is enabled
    Then view type "List view" is disabled
    Then view type "Map view" is disabled


  Scenario: search for property in Portsmouth with default and fixed values and validate the different search views
    When I navigate to the rent property section
    And I search for a property in "Portsmouth" with minimum price "£500 pcm" maximum price "No max"  and type "Show all"
    Then rental type is correct "rent"
    Then view type "List view" is enabled
    Then view type "Grid view" is disabled
    Then view type "Map view" is disabled
    When I select view "Grid view"
    Then view type "Grid view" is enabled
    Then view type "List view" is disabled
    Then view type "Map view" is disabled


