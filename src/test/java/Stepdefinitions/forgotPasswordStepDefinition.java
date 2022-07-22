package Stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class forgotPasswordStepDefinition
{
    WebDriver driver;
    @When("^I click on Forgot password link in login panel$")
    public void selectForgotPasswordLink() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[@title = \"Recover your forgotten password\"]")).click();
        Thread.sleep(5000);
    }
    @Then("^I should be navigated to password recovery page$")
    public void userIsOnPasswordRecoveryPage()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".page-subheading")).isDisplayed());
    }
    @When("^I enter an email (.*) to retrieve forgot password$")
    public void enterEmailToGetForgotPassword(String forgotemail)throws InterruptedException
    {
        driver.findElement(By.cssSelector("#email")).sendKeys(forgotemail);
        Thread.sleep(5000);
    }
    @And("^I click on Retrieve Password button$")
    public void selectRetrievePwdButton()
    {
        driver.findElement(By.xpath("//button[@class = 'btn btn-default button button-medium']")).click();

    }
    @Then("^I should see the confirmation message (.*)$")
    public void userCanSeeTheConfirmationMessage(String message)
    {
        String displayedtext = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
        Assert.assertTrue(displayedtext.contains(message));
    }
}
