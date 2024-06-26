package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.CookieClickerSelectors;
import stepdefinitions.Runners.Hooks;

import java.time.Duration;

public class CookieClickerGameStepDefs extends CookieClickerSelectors {

    @Given("I enter {string} into the name input field")
    public void i_enter_into_the_name_input_field(String username) {
        // Find username
        WebElement usernameInput = Hooks.driver.findElement(By.cssSelector(ADD_USERNAME));

        // Enter username
        usernameInput.sendKeys(username);

    }

    @When("I click the Start button")
    public void i_click_the_start_button() {
        Hooks.driver.findElement(By.cssSelector(START_BUTTON)).click();
    }

    @Then("a new game should start for {string}")
    public void a_new_game_should_start_for(String string) {
        // Find the shopping cart container element
        WebElement helloMessageElement = Hooks.driver.findElement(By.cssSelector(HELLO_MESSAGE));

        // Retrieve the text content of the element
        String actualMessage = helloMessageElement.getText().trim(); // Ensure to trim any whitespace

        // Define the expected message
        String expectedMessage = "Hello Player1";

        // Assert that the actual message matches the expected message
        Assert.assertEquals("Expected hello message to be '" + expectedMessage + "', but it was '" + actualMessage + "'.", expectedMessage, actualMessage);
    }

    @Then("I click on the Cookie Clicker homepage link")
    public void i_click_on_the_cookie_clicker_homepage_link() {
        Hooks.driver.findElement(By.cssSelector(COOKIE_CLICKER_LINK)).click();
    }

    @Then("the score for {string} should be displayed on the High Scores list")
    public void the_score_for_should_be_displayed_on_the_high_scores_list(String playerName) {
        // Locate the row that contains the player's name using the passed string argument
        WebElement playerLink = Hooks.driver.findElement(
                By.xpath(PLAYER_TABLE + playerName + "']]/td/a")
        );

        // Get the actual player name displayed in the <a> element and trim any extra whitespace
        String actualPlayerName = playerLink.getText().trim();

        // Assert that the player name is as expected
        Assert.assertEquals("Expected to find '" + playerName + "' in the table, but it was not found. Actual value: '" + actualPlayerName + "'.", playerName, actualPlayerName);
    }

    @Then("the initial number of cookies should be {int}")
    public void the_number_of_initial_cookies_should_be(Integer expectedCookies) {
        // Locate the element with the CSS selector 'cookies'
        WebElement cookiesField = Hooks.driver.findElement(By.cssSelector(COOKIES_COUNTER));

        // Get the text content or value of the element
        String cookiesValue = cookiesField.getText().trim(); // If the text is inside the element


        // Parse the actual cookies value as an integer
        Integer actualCookies = Integer.parseInt(cookiesValue);
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        // Assert that the value is equal to the expected number of cookies
        Assert.assertEquals("Expected the cookies field to contain '" + expectedCookies + "', but it was '" + actualCookies + "'.", expectedCookies, actualCookies);
    }

    @Then("the initial number of factories should be {int}")
    public void the_initial_number_of_cookies_should_be(Integer expectedFactories) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        boolean valueUpdated = wait.until(ExpectedConditions.textToBe(By.cssSelector(FACTORIES_COUNTER), expectedFactories.toString()));

        // Get the factories counter element
        WebElement factoriesField = Hooks.driver.findElement(By.cssSelector(FACTORIES_COUNTER));

        // Get the text content of the element
        String factoriesValue = factoriesField.getText().trim();

        // Parse the actual factories value as an integer
        Integer actualFactories = Integer.parseInt(factoriesValue);

        // Print the actual value for debugging purposes
        System.out.println("Actual factories value: " + actualFactories);

        // Assert that the value is equal to the expected number of factories
        Assert.assertEquals("Expected the factories field to contain '" + expectedFactories + "', but it was '" + actualFactories + "'.", expectedFactories, actualFactories);
    }

    @Then("the initial amount of money should be ${double}")
    public void the_initial_amount_of_money_should_be_$(Double expectedMoney) throws InterruptedException {

        WebElement moneyField = Hooks.driver.findElement(By.cssSelector(MONEY_COUNTER));

        // Get the text content or value of the element
        String moneyValue = moneyField.getText().trim(); // If the text is inside the element


        // Parse the actual money value as an integer
        Integer actualMoney = Integer.parseInt(moneyValue);

        // Assert that the value is equal to the expected value of money
        Assert.assertEquals("Expected the cookies field to contain '" + expectedMoney + "', but it was '" + actualMoney + "'.", expectedMoney, actualMoney);

    }

    @When("I click the click cookie button to the value of $3")
    public void i_click_the_button_value_three() {
        // Locate the element with the CSS selector 'click-cookie-button'
        WebElement clickCookieButton = Hooks.driver.findElement(By.cssSelector(CLICK_COOKIE_BUTTON));

        // Click the button 12 times using a loop
        for (int i = 0; i < 12; i++) {
            clickCookieButton.click();
        }
    }

    @Then("the number of cookies should increase by {int}")
    public void the_number_of_cookies_should_increase_by(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter {string} into the sell cookies input field")
    public void i_enter_into_the_sell_cookies_input_field(String cookies) {
        // Locate the sell cookies input field
        WebElement cookiesInputField = Hooks.driver.findElement(By.xpath(Enter_COOKIES_AMOUNT));

        // Clear the field before entering the value
        cookiesInputField.clear();

        // Enter the value into the input field
        cookiesInputField.sendKeys(cookies);

        // Debugging: Print the entered value to ensure it was input correctly
        System.out.println("Entered value: " + cookies);
    }

    @When("I click the sell cookies button")
    public void i_click_the_sell_cookies_button() {
        Hooks.driver.findElement(By.id(SELL_COOKIES)).click();
    }

    @Given("I click the sell cookies button to the value of $3")
    public void i_click_the_sell_cookies_button_to_the_value_of_$() {
        WebElement clickCookieButton = Hooks.driver.findElement(By.id(SELL_COOKIES));

        // Click the button 12 times using a loop
        for (int i = 0; i < 12; i++) {
            clickCookieButton.click();
        }
    }

    @Then("the number of cookies should decrease by {int}")
    public void the_number_of_cookies_should_decrease_by(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the amount of money should increase by ${double}")
    public void the_amount_of_money_should_increase_by_$(Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I have ${int}")
    public void i_have_$(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter {string} into the buy factories input field")
    public void i_enter_into_the_buy_factories_input_field(String factories) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(4));
        // Locate the sell cookies input field
        WebElement factoriesInputField = Hooks.driver.findElement(By.xpath(ENTER_FACTORIES));

        // Clear the field before entering the value
        factoriesInputField.clear();

        // Enter the value into the input field
        factoriesInputField.sendKeys(factories);

        // Debugging: Print the entered value to ensure it was input correctly
        System.out.println("Entered value: " + factories);
    }

    @When("I click the buy factories button")
    public void i_click_the_buy_factories_button() {
        Hooks.driver.findElement(By.id(BUY_FACTORIES)).click();
    }

    @Then("the number of factories should increase by {int}")
    public void the_number_of_factories_should_increase_by(Integer int1) {

    }

    @Then("the amount of money should decrease by £{int}")
    public void the_amount_of_money_should_decrease_by_£(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I enter a very long name \\(e.g., {int} characters) into the name input field")
    public void i_enter_a_very_long_name_e_g_characters_into_the_name_input_field(Integer int1) {
        // Generate a long string of 100 characters
        StringBuilder longUsername = new StringBuilder(100);
        for (int i = 0; i < 100; i++) {
            longUsername.append('a');
        }

        // Locate the username input field
        WebElement usernameInput = Hooks.driver.findElement(By.cssSelector(ADD_USERNAME));

        // Clear the field before entering the value
        usernameInput.clear();

        // Enter the long username into the input field
        usernameInput.sendKeys(longUsername.toString());
    }

    @Then("an error message should be displayed indicating that the name exceeds the maximum length")
    public void an_error_message_should_be_displayed_indicating_that_the_name_exceeds_the_maximum_length() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see an error message stating not enough cookies to sell")
    public void i_should_see_an_error_message_stating_not_enough_cookies_to_sell() {
        //Add error assertion here when built
    }

    @Then("I should see an error message stating not enough money to buy a factory")
    public void i_should_see_an_error_message_stating_not_enough_money_to_buy_a_factory() {
        //Add error assertion here when built
    }

    @Then("I should see an error message stating too many characters in the username")
    public void i_should_see_an_error_message_stating_too_many_characters_in_the_username() {
        //Add error assertion here when built
    }
}


