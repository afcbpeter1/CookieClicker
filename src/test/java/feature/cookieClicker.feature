Feature: Cookie Clicker Game

  Scenario: Start a new game with a valid name
    Given I am on the Cookie Clicker game page
    When I enter "Player1" into the name input field
    And I click the Start button
    Then a new game should start for "Player1"
    And the score for "Player1" should be displayed on the High Scores list

  Scenario: Start a new game with a name containing special characters
    Given I am on the Cookie Clicker game page
    When I enter "@#$%" into the name input field
    And I click the Start button
    Then a new game should start for "@#$%"

  Scenario: Initial game state
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "Test5"
    Then the initial number of cookies should be 0
    And the initial number of factories should be 0
    And the initial amount of money should be $0

  Scenario: Click to add cookies
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "Test5"
    And I click the "Click Cookie!" button
    Then the number of cookies should increase by 1

  Scenario: Sell cookies
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "Test5"
    And I have 2 cookie
    And I enter "1" into the sell cookies input field
    And I click the sell cookies button
    Then the number of cookies should decrease by 1
    And the amount of money should increase by $0.25

  Scenario: Sell all cookies
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "Test5"
    And I have 1 cookie
    And I enter "1" into the sell cookies input field
    And I click the sell cookies button
    Then the number of cookies should decrease by 1
    And the amount of money should increase by $0.25

  Scenario: Buy factories
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "Test5"
    And I have $100
    And I enter "1" into the buy factories input field
    And I click the "Buy Factories!" button
    Then the number of factories should increase by 1
    And the amount of money should decrease by £3

  Scenario: Insufficient cookies to sell
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "Test5"
    And I have 5 cookies
    And I enter "10" into the sell cookies input field
    And I click the "Sell Cookies!" button
    Then an error message should be displayed indicating insufficient cookies
    And the number of cookies should remain unchanged

  Scenario: Insufficient money to buy factories
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "Test5"
    And I have $0
    And I enter "1" into the buy factories input field
    And I click the "Buy Factories!" button
    Then an error message should be displayed indicating insufficient funds
    And the number of factories should remain unchanged

  Scenario: Clicking Cookie Button Without Starting Game
    Given I am on the Cookie Clicker game page
    When I do not enter a name
    And I do not click the "Start!" button
    And I click the "Click Cookie!" button
    Then an error message should be displayed indicating that a game needs to be started first
    And no cookies should be added

  Scenario: Maximum Length of Username
    Given I am on the Cookie Clicker game page
    When I enter a very long name (e.g., 100 characters) into the name input field
    And I click the "Start!" button
    Then an error message should be displayed indicating that the name exceeds the maximum length
    And the game should not start

  Scenario: Handling Negative Money
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "TestDebt"
    And I have a minus number
    Then the amount of money should be reset to $0
    And an error message should be displayed indicating an invalid money amount

  Scenario: Exceeding Maximum Cookies
    Given I am on the Cookie Clicker game page
    When I start a new game with the name "TestOverflow"
    And I manually set the cookie count to a very high number
    Then the game should handle the large number gracefully without crashing
    And the number of cookies should be displayed correctly