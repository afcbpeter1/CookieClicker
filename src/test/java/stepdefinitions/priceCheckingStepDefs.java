package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class priceCheckingStepDefs {

    @When("I click Back to products")
    public void i_click_back_to_products() {
        Hooks.driver.findElement(By.cssSelector("#back-to-products")).click();
    }

    //Bug when moving back to the all products page the prices of all the products change
    @Then("I should see the value of $7.99")
    public void i_should_see_the_value_of_product() {

        WebElement onesiePrice = Hooks.driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(5) > div.inventory_item_description > div.pricebar > div"));
        // Assert that the element is visible
        String actualPrice = onesiePrice.getText().trim();

        // Assert the actual price text matches the expected price
        Assert.assertEquals("Expected product price to be $7.99, but found: " + actualPrice, "$7.99", actualPrice);
    }
}
