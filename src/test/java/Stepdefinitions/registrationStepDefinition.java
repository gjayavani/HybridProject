package Stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class registrationStepDefinition
{
    WebDriver driver;

    @When("^I enter an email as (.*)$")
    public void enterEmailToCreateAnAccount(String email)
    {
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
    }
    @And("^click on submit tab$")
    public void userSelectCreateAccountTab() throws InterruptedException
    {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();
    }
    @Then("^I should navigate to Create an account page$")
    public void isUserOnCreateAnAccountPage() throws InterruptedException
    {
        Assert.assertTrue(driver.findElement(By.cssSelector(".page-heading")).isDisplayed());
        Thread.sleep(5000);
    }
    @And("^I should enter all the user details like title (.*),firstname (.*),lastname (.*),password (.*)$")
    public void enterUserDetails(String title,String firstname,String lastname,String password) throws InterruptedException
    {
        if(title.equalsIgnoreCase("Mr"))
        {
            driver.findElement(By.cssSelector("#id_gender1")).click();
        }
        else if(title.equalsIgnoreCase("Mrs"))
        {
            driver.findElement(By.cssSelector("#id_gender2")).click();
        }
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(firstname);
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(lastname);
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
    }
    @And("^I should enter Day (.*),Month (.*),Year (.*)$")
    public void enterDOB(String day,String month,String year)throws InterruptedException
    {
        Thread.sleep(10000);
        Select selectday = new Select(driver.findElement(By.cssSelector("#days")));
        selectday.selectByValue(day);
        Select selectmonth = new Select(driver.findElement(By.cssSelector("#months")));
        selectmonth.selectByValue(month);
        Select selectyear = new Select(driver.findElement(By.cssSelector("#years")));
        selectyear.selectByValue(year);
    }
    @And("^I should enter address (.*),city (.*),state (.*),zip (.*)$")
    public void enterCityAddressStateZip(String address,String city,String state,String zip)
    {
        driver.findElement(By.cssSelector("#address1")).sendKeys(address);
        driver.findElement(By.cssSelector("#city")).sendKeys(city);
        Select selectstate = new Select(driver.findElement(By.cssSelector("#id_state")));
        selectstate.selectByVisibleText(state);
        driver.findElement(By.cssSelector("#postcode")).sendKeys(zip);
    }
    @And("^I should enter country (.*),mobile (.*)$")
    public void enterCountryMobileno(String country,String mobile)
    {
        Select selectcountry = new Select(driver.findElement(By.cssSelector("#id_country")));
        selectcountry.selectByVisibleText(country);
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(mobile);
    }
    @And("^I provide details as address,city,state,zip$")
    public void provideRegistrationDetails(DataTable table) throws InterruptedException
    {
        List<String> data = table.asList();

        String address1 = data.get(0);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#address1")).sendKeys(address1);
        driver.findElement(By.cssSelector("#city")).sendKeys(data.get(1));
        Select selectstate = new Select(driver.findElement(By.cssSelector("#id_state")));
        selectstate.selectByVisibleText(data.get(2));
        driver.findElement(By.cssSelector("#postcode")).sendKeys(data.get(3));
    }
    @When("^I should click on Register button$")
    public void userSelectRegisterTab()
    {
        driver.findElement(By.cssSelector("#submitAccount")).click();
    }
    @Then("^I should see an error message (.*)$")
    public void userCanSeeErrorMessage(String error) throws InterruptedException
    {
        String errormessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        Assert.assertEquals(error,errormessage);
        Thread.sleep(20000);
    }

}