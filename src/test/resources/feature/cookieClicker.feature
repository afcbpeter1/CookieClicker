Feature: Cookie Clicker Game

  @Test
  Scenario: Start a new game with a valid name
    Given I enter "Player1" into the name input field
    And I click the Start button
    Then a new game should start for "Player1"
    And I click on the Cookie Clicker homepage link
    And the score for "Player1" should be displayed on the High Scores list

  @Test
  Scenario: Initial game state
    Given I enter "Player1" into the name input field
    And I click the Start button
    Then the initial number of cookies should be 0
    And the initial number of factories should be 0
    And the initial amount of money should be $0
    #Bug final step shows $0.0

  @Test
  Scenario: Click to add cookies
    Given I enter "Player3" into the name input field
    And I click the Start button
    And I click the click cookie button to the value of $3
    Then the initial number of cookies should be 12
    #Bug when clicking on the button once it doesnt log the click in the backend. So clicking twice only gives you one cookie, visually it shows two.

  @Test
  Scenario: Sell cookies
    Given I enter "Player5" into the name input field
    And I click the Start button
    And I click the click cookie button to the value of $3
    And I enter "1" into the sell cookies input field
    And I click the sell cookies button
    Then the initial number of cookies should be 11
    #Bug returns 11 still probably related to the above
    And the initial amount of money should be $0.25
    #Same bug as above showing 0.0 in the initial state when screen loads

  @Test
  Scenario: Buy factories
    Given I enter "Player6" into the name input field
    And I click the Start button
    And I click the click cookie button to the value of $3
    And I enter "12" into the sell cookies input field
#    Bug here as you can't actually sell all of your cookies, so needs some error handling to prevent it
    And I click the sell cookies button to the value of $3
    And I enter "1" into the buy factories input field
    And I click the buy factories button
    And the initial number of factories should be 1
    And the initial amount of money should be $3
#    Same bug as before as the initial state shows $0.0 the test fails as it's actual is -3

#The below tests would require some kind of error handling to work correctly
  @Test
  Scenario: Insufficient cookies to sell
    Given I enter "Player7" into the name input field
    And I click the Start button
    And I click the click cookie button to the value of $3
    And I enter "20" into the sell cookies input field
    Then I should see an error message stating not enough cookies to sell

  @Test
  Scenario: Insufficient money to buy factories
    Given I enter "Player6" into the name input field
    And I click the Start button
    And I click the click cookie button to the value of $3
    And I enter "12" into the sell cookies input field
#    Bug here as you can't actually sell all of your cookies, so needs some error handling to prevent it
    And I click the sell cookies button to the value of $3
    And I enter "2" into the buy factories input field
#    Same bug as before as the initial state shows
    Then I should see an error message stating not enough money to buy a factory

  @Test
  Scenario: Maximum Length of Username
    Given I enter a very long name (e.g., 100 characters) into the name input field
    And I click the Start button
    Then I should see an error message stating too many characters in the username
