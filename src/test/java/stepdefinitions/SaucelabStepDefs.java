package stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import runners.Selectors;
import stepdefinitions.Runners.Hooks;

public class SaucelabStepDefs extends Selectors {

    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String username, String password) {

        // Find username and password input fields using CSS selectors
        WebElement usernameInput = Hooks.driver.findElement(By.cssSelector(USERNAME_INPUT));
        WebElement passwordInput = Hooks.driver.findElement(By.cssSelector(PASSWORD_INPUT));

        // Enter username and password
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Hooks.driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    @Then("I should be redirected to the Products page displaying available products")
    public void i_should_be_redirected_to_the_products_page_displaying_available_products() {

        // Find the Products title container
        WebElement productTitle = Hooks.driver.findElement(By.cssSelector(PRODUCT_TITLE));

        // Assert that the element is visible
        Assert.assertTrue("Expected product title container to be visible, but it was not.", productTitle.isDisplayed());

        // Find the shopping cart container element
        WebElement cartContainer = Hooks.driver.findElement(By.cssSelector(CART_CONTAINER));

        // Assert that the element is visible
        Assert.assertTrue("Expected shopping cart container to be visible, but it was not.", cartContainer.isDisplayed());
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedErrorMessage) {
        System.out.println("Verifying error message: " + expectedErrorMessage);
        WebElement errorMessageElement = Hooks.driver.findElement(By.cssSelector(ERROR_MESSAGE));
        String actualErrorMessage = errorMessageElement.getText();
        Assert.assertEquals("Expected error message to be '" + expectedErrorMessage + "' but was '" + actualErrorMessage + "'", expectedErrorMessage, actualErrorMessage);
    }
}
