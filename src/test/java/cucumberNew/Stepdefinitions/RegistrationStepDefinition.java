package cucumberNew.Stepdefinitions;

import io.cucumber.datatable.DataTable;
import cucumberNew.Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationStepDefinition
{
    RegistrationPage authenticate = new RegistrationPage();
    @When("^I enter an email as (.*)$")
    public void enterEmailToCreateAnAccount(String email)
    {
        authenticate.enterEmailToCreate(email);
    }
    @And("^click on submit tab$")
    public void userSelectCreateAccountTab() throws InterruptedException
    {
        Thread.sleep(10000);
        authenticate.selectCreateAccountTab();
    }
    @Then("^I should navigate to Create an account page$")
    public void isUserOnAuthentication()
    {
       Assert.assertTrue(authenticate.userOnAuthentication());
    }

    @And("^I should enter all the user details like title (.*),firstname (.*),lastname (.*),password (.*)$")
    public void enterUserDetails(String title,String firstname,String lastname,String password) throws InterruptedException
    {
        authenticate.enterDetails(title,firstname,lastname,password);
    }
    @And("^I should enter Day (.*),Month (.*),Year (.*)$")
    public void enterDOB(String day,String month,String year)throws InterruptedException
    {
        Thread.sleep(10000);
        authenticate.enterDOB(day,month,year);
     }
    @And("^I should enter address (.*),city (.*),state (.*),zip (.*),mobile (.*)$")
    public void enterCityAddressStateZip(String address,String city,String state,String zip,String mobile)
    {
       authenticate.enterAddress(address,city,state,zip,mobile);
    }
   @And("^I provide details as address,city,state,zip,mobile$")
    public void provideRegistrationDetails(DataTable table) throws InterruptedException
    {
     authenticate.provideRegistrationDetails(table);
    }
    @When("^I should click on Register button$")
    public void userSelectRegisterTab()
    {
        authenticate.submitTab();
    }
    @Then("^I should see an error message (.*)$")
    public void userCanSeeErrorMessage(String error) throws InterruptedException
    {
        String errormessage = authenticate.verifyMessage();
        Assert.assertEquals(error,errormessage);
        Thread.sleep(20000);
    }

}

