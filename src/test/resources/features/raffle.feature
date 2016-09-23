Feature: Test the raffle

  # Happy path scenarios #############################################################################
Scenario: Register a valid user and request less than max number of tickets
  Given I have requested a raffle with "6" number of tickets
  And I have requested to register a player with name "kostas" and email "kostas@yahoo.com" and dob "14/09/1986"
  Then player is successfully registered
  Then I successfully request "5" tickets for player "kostas"
  And successfully request the details for "kostas" with email "kostas@yahoo.com" and dob "14/09/1986"


  Scenario: Register a valid user and request max number of tickets
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "john" and email "john@yahoo.com" and dob "14/01/1980"
    Then player is successfully registered
    Then I successfully request "6" tickets for player "john"
    And successfully request the details for "john" with email "john@yahoo.com" and dob "14/01/1980"

  Scenario: Register 2 valid users and request max number of tickets for a given raffle
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "john" and email "john@yahoo.com" and dob "14/01/1980"
    Then player is successfully registered
    Then I successfully request "4" tickets for player "john"
    And successfully request the details for "john" with email "john@yahoo.com" and dob "14/01/1980"
    When I have requested to register a player with name "jenny" and email "jenny@yahoo.com" and dob "14/01/1970"
    Then player is successfully registered
    Then I successfully request "2" tickets for player "jenny"
    And successfully request the details for "jenny" with email "jenny@yahoo.com" and dob "14/01/1970"

  Scenario: Register 2 valid users with same email address  and request max number of tickets for a given raffle
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "john" and email "john@yahoo.com" and dob "14/01/1980"
    Then player is successfully registered
    Then I successfully request "4" tickets for player "john"
    And successfully request the details for "john" with email "john@yahoo.com" and dob "14/01/1980"
    When I have requested to register a player with name "jenny" and email "john@yahoo.com" and dob "14/01/1980"
    Then player is successfully registered
    Then I successfully request "2" tickets for player "jenny"
    And successfully request the details for "jenny" with email "john@yahoo.com" and dob "14/01/1980"

  Scenario: Register 1 valid user with 2 different email addresses and request max number of tickets for a given raffle
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "john" and email "john@yahoo.com" and dob "14/01/1980"
    Then player is successfully registered
    Then I successfully request "4" tickets for player "john"
    And successfully request the details for "john" with email "john@yahoo.com" and dob "14/01/1980"
    When I have requested to register a player with name "john" and email "jenny@yahoo.com" and dob "14/01/1980"
    Then player is successfully registered
    Then I successfully request "2" tickets for player "john"
    And successfully request the details for "john" with email "jenny@yahoo.com" and dob "14/01/1980"


    #Negative path scenarios ####################################################################

  Scenario: Register a valid user and request more than the max number of tickets
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "kostas" and email "kostas@yahoo.com" and dob "14/09/1986"
    Then player is successfully registered
    Then I request "7" number of tickets for player "kostas" with correct error message "Tickets not available" for the non available tickets


  Scenario: Attempt to register a user with invalid email address and request tickets for a given raffle
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "kostas" and email "kostasyahoo.com" and dob "14/09/1986"
    Then I get error message "Wrong email format"
    When I request "1" tickets for non existing player
    Then I get error message "Player not found"

  Scenario: Attempt to register a user with invalid date format and request tickets for a given raffle
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "kostas" and email "kostasyahoo.com" and dob "09/14/1986"
    Then I get error message "Wrong format data, use dd/MM/yyyy"
    When I request "1" tickets for non existing player
    Then I get error message "Player not found"

  Scenario: Attempt to register a valid user and request tickets for a non existing raffle
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register a player with name "kostas" and email "kostas@yahoo.com" and dob "14/09/1986"
    When I request "1" tickets for non existing raffle for user "kostas"
    Then I get error message "Raffle not found"


  Scenario: Attempt to register an underaged user
    Given I have requested a raffle with "6" number of tickets
    And I have requested to register an underaged player with name "kostas" and email "kostas@yahoo.com"
    Then I get error message "Invalid birth date. Player needs to be at least 18."

  Scenario: Attempt to request details for an non existing player
    Given I have requested a raffle with "6" number of tickets
    And I request details for a non existing player with player id "12$%455"
    Then I get error code "400"
