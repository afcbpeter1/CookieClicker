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

  Scenario Outline: Display appropriate error message for various user types
    Given I enter the username "<username>" and password "secret_sauce"
    Then I should see the error message "<error_message>"

    Examples:
      | username               | error_message                                                                |
      | locked_out_user        | "Epic sadface: Sorry, this user has been locked out."                        |
      | error_user1            | "Epic sadface: Username and password do not match any user in this service." |

#  Bug scenario checking for the correct price of a product by moving pages
  Scenario: Checking for the price of an item has the correct value
    Given I enter the username "visual_user" and password "secret_sauce"
    When I click on the product Sauce Labs Onesie
    And I click Back to products
    Then I should see the value of $7.99

