Feature: As a user i want to be able to filter my serach results in the ebay home page

    Background:
        Given I am on the ebay home page


    Scenario: search for a product by all Auction and lowest price P&P
        When I search for an item "books"
        And I filter my search by Auction
        And I sort my search by "Lowest price + P&P"
        Then bid price is displayed for all items


    Scenario: search for a product by all listings and lowest price P&P
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by "Lowest price + P&P"
        Then free postage and price are displayed for all items

    Scenario: search for a product by all listings and lowest best match
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by "Best Match"
        Then price is displayed for all items

    Scenario: search for a product by all listings and highest price P&P
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by "Highest price + P&P"
        Then price is displayed for all items

    Scenario: search for a product by all listings and lowest price
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by "Lowest price"
        Then price is displayed for all items

    Scenario: search for a product by all listings and highest price
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by "Highest price"
        Then price is displayed for all items


    Scenario: search for a product by all listings and newly listed
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by "Newly listed"
        Then price is displayed for all items

    Scenario: search for a produNewly listedct by all listings and ending soonest
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by "Ending soonest"
        Then price is displayed for all items

    Scenario: search for a produNewly listedct by all listings and nearest first
        When I search for an item "books"
        And I filter my search by All listings
        And I sort my search by " Nearest First"
        Then price is displayed for all items

    Scenario: search for a product by buy it now and lowest price P&P
        When I search for an item "books"
        And I filter my search by Buy it now
        And I sort my search by "Lowest price + P&P"
        Then buy it now logo is displayed for all items