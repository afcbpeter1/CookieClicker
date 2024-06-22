package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductCartStepDefs {


    @When("I click on the product Sauce Labs Onesie")
    public void i_click_on_the_product_sauce_labs_onesie() {
        // Wait for 3 seconds using WebDriverWait
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#item_2_img_link > img")));

        Hooks.driver.findElement(By.cssSelector("#item_2_img_link > img")).click();
        //Find the Products name container
        WebElement productName = Hooks.driver.findElement(By.cssSelector("div.inventory_details_name.large_size[data-test='inventory-item-name"));
        // Assert that the element is visible
        Assert.assertTrue("Expected product name container to be visible, but it was not.", productName.isDisplayed());
        //Find the product description container element
        WebElement productDescription = Hooks.driver.findElement(By.cssSelector("div.inventory_details_desc.large_size[data-test='inventory-item-desc']"));
        // Assert that the element is visible
        Assert.assertTrue("Expected product description to be visible, but it was not.", productDescription.isDisplayed());
        // Find the product price container element
        WebElement productPrice = Hooks.driver.findElement(By.cssSelector("div.inventory_details_price[data-test='inventory-item-price']"));
        // Assert that the element is visible
        String actualPriceText = productPrice.getText().trim();

        // Assert the actual price text matches the expected price
        Assert.assertEquals("Expected product price to be $7.99, but found: " + actualPriceText, "$7.99", actualPriceText);
    }

    @When("I click on the add to cart button for that product")
    public void i_click_on_the_button_for_that_product() {
        // Locate the button by its text and click it
        Hooks.driver.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory[data-test='add-to-cart")).click();
    }

    @Then("the product should be added to my cart and the cart icon should show an updated count of items")
    public void the_product_should_be_added_to_my_cart_and_the_cart_icon_should_show_an_updated_count_of_items() {
        //Assert item is in cart
        Hooks.driver.findElement(By.cssSelector("a.shopping_cart_link > span.shopping_cart_badge")).click();
        WebElement addedToCart = Hooks.driver.findElement(By.cssSelector("div.cart_item[data-test='inventory-item']"));
        // Assert that the element is visible
        Assert.assertTrue("Expected product description to be visible, but it was not.", addedToCart.isDisplayed());
    }

    @Then("I click on the checkout button")
    public void i_click_on_the_checout_button() {
        Hooks.driver.findElement(By.cssSelector("button.btn.btn_action.btn_medium.checkout_button[data-test='checkout']")).click();
    }
    @Then("I enter the first name {string} last name {string} and postcode {string}")
    public void i_enter_the_first_name_last_name_and_postcode(String firstName, String lastName, String postcode) {
        // Find fields using css selectors
        WebElement firstNameInput = Hooks.driver.findElement(By.cssSelector("#first-name"));
        WebElement lastNameInput = Hooks.driver.findElement(By.cssSelector("#last-name"));
        WebElement postcodeInput = Hooks.driver.findElement(By.cssSelector("#postal-code"));

        // Enter username and password
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postcodeInput.sendKeys(postcode);
    }

    @When("I click the continue button")
    public void i_click_the_continue_button() {
        Hooks.driver.findElement(By.cssSelector("#continue")).click();
    }
    @Then("I should see the checkout total")
    public void i_should_see_the_checkout_total() {
        WebElement totalPrice = Hooks.driver.findElement(By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_total_label"));
        // Assert that the element is visible
        Assert.assertTrue("Expected total price to be visible, but it was not.", totalPrice.isDisplayed());
    }
    @Then("I select finish")
    public void i_select_finish() {
        Hooks.driver.findElement(By.cssSelector("#finish")).click();
    }
    @Then("I should be on the thank you for your order page")
    public void i_should_be_on_the_thank_you_for_your_order_page() {
        WebElement orderComplete = Hooks.driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        // Assert that the element is visible
        Assert.assertTrue("Expected order completion message to be visible, but it was not.", orderComplete.isDisplayed());
    }
}
