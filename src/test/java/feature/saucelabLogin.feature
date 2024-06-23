Feature: Login and Product Purchase on Sauce Demo

  Scenario: Successful Login
    Given I enter the username "standard_user" and password "secret_sauce"
    Then I should be redirected to the Products page displaying available products

  Scenario: Adding a product to cart and purchasing
    Given I enter the username "standard_user" and password "secret_sauce"
    When I click on the product Sauce Labs Onesie
    And I click on the add to cart button for that product
    Then the product should be added to my cart and the cart icon should show an updated count of items
    And I click on the checkout button
    And I enter the first name "Test" last name "User" and postcode "wf104tu"
    When I click the continue button
    Then I should see the checkout total
    And I select finish
    Then I should be on the thank you for your order page

  Scenario Outline: Display appropriate error message for various invalid user types
    Given I enter the username "<username>" and password "<password>"
    Then I should see the error message "<error_message>"

    Examples:
      | username               | password               |error_message                                                              |
      | locked_out_user        | secret_sauce           |Epic sadface: Sorry, this user has been locked out.                        |
      | error_user1            | secret_sauce1          |Epic sadface: Username and password do not match any user in this service  |

#  Bug scenario checking for the correct price of a product by moving pages
#  The purpose of a test like this would be preventing a re-release of a production issue found for example
  Scenario: Checking for the price of an item has the correct value
    Given I enter the username "visual_user" and password "secret_sauce"
    When I click on the product Sauce Labs Onesie
    And I click Back to products
    Then I should see the value of $7.99

