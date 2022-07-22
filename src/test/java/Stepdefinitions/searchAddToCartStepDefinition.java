package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchAddToCartStepDefinition
{
    WebDriver driver;

    @When("^I enter the product name as (.*) in search box$")
    public void searchAProduct(String product) throws InterruptedException
    {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(product);
    }
    @And("^I click on search button$")
    public void selectSubmitButton() throws InterruptedException
    {
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
    }
    @When("^I select the product (.*)$")
    public void selectTheProduct(String color) throws InterruptedException
    {
        Thread.sleep(10000);
        driver.findElement(By.xpath("//img[@title='Printed Dress']")).click();
        Thread.sleep(5000);
        switch (color)
        {
            case "pink" :
                driver.findElement(By.cssSelector("#color_24")).click();
                break;
            case "beige" :
                driver.findElement(By.cssSelector("#color_7")).click();
                break;
        }
        Thread.sleep(5000);
    }
    @And("^I add the product to the cart$")
    public void addTheCart() throws InterruptedException
    {
        driver.findElement(By.xpath("//button[@name='Submit']")).click();
        Thread.sleep(5000);
    }
    @Then("^I should see the product added to the cart$")
    public void CheckTheCart() throws InterruptedException
    {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/h2/span[2]")).isDisplayed());
        Thread.sleep(5000);
    }
    @When("^I select the Proceed to checkout tab$")
    public void proceedToCheckout()
    {
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
    }
}