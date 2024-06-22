package stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

public class SaucelabStepDefs {

    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String username, String password) {

        // Find username and password input fields using CSS selectors
        WebElement usernameInput = Hooks.driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordInput = Hooks.driver.findElement(By.cssSelector("#password"));

        // Enter username and password
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Hooks.driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("I should be redirected to the Products page displaying available products")
    public void i_should_be_redirected_to_the_products_page_displaying_available_products() {

        // Find the Products title container
        WebElement productTitle = Hooks.driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));

        // Assert that the element is visible
        Assert.assertTrue("Expected product title container to be visible, but it was not.", productTitle.isDisplayed());

        // Find the shopping cart container element
        WebElement cartContainer = Hooks.driver.findElement(By.cssSelector("#shopping_cart_container > a"));

        // Assert that the element is visible
        Assert.assertTrue("Expected shopping cart container to be visible, but it was not.", cartContainer.isDisplayed());
    }

    //I have no idea what is going on with these two step defs I wanted to add it to one but some quirky cucumber issue maybe I need to investigate further.
    //It should work under one definition but the errors it's looking for are different, that shouldn't even matter in a data table? Potential bug?
    @Then("I should see the error message \"\"Epic sadface: Sorry, this user has been locked out.{string}")
    public void i_should_see_the_error_message_epic_sadface_sorry_this_user_has_been_locked_out(String expectedErrorMessage) {
        System.out.println("Verifying error message: " + expectedErrorMessage);
        WebElement errorMessageElement = Hooks.driver.findElement(By.cssSelector("h3[data-test='error'] button.error-button"));
        String actualErrorMessage = errorMessageElement.getText();
        Assert.assertEquals("Expected error message to be '" + expectedErrorMessage + "' but was '" + actualErrorMessage + "'", expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see the error message \"\"Epic sadface: Username and password do not match any user in this service.{string}")
    public void i_should_see_the_error_message_epic_sadface_username_and_password_do_not_match_any_user_in_this_service(String expectedErrorMessage) {
        System.out.println("Verifying error message: " + expectedErrorMessage);
        WebElement errorMessageElement = Hooks.driver.findElement(By.cssSelector("h3[data-test='error'] button.error-button"));
        String actualErrorMessage = errorMessageElement.getText();
        Assert.assertEquals("Expected error message to be '" + expectedErrorMessage + "' but was '" + actualErrorMessage + "'", expectedErrorMessage, actualErrorMessage);
    }
}
