package cucumberNew.Stepdefinitions;

import cucumberNew.Pages.LoginPage;
import cucumberNew.Utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefinition
{
    LoginPage login = new LoginPage();
    @Then("^I should be on the Authentication page$")
    public void isUserOnAuthenticationPage() throws InterruptedException
    {
        Assert.assertTrue(login.userOnAuthentication());
                Thread.sleep(5000);
    }
    @When("^I enter email as (.*) & password as (.*)$")
    public void enterValidCredentials(String username,String password) throws InterruptedException
    {
        Thread.sleep(10000);
        login.enterEmailPwdToLogin(username,password);
    }
    @And("^I select sign in link$")
    public void selectSigninTab() throws InterruptedException
    {
        Thread.sleep(10000);
        login.selectSigninTab();
     }
    /* @Then("^I should be on the Authentication page$")
   public void verifyLogin()
   {
       Assert.assertEquals(login.userLoggedIn(), Utils.getPageTitle());
   }*/
    @And("^I should be on My account page$")
    public void isUserOnMyAccountPage() throws InterruptedException
    {
        Thread.sleep(10000);
        Assert.assertTrue(login.userOnMyAccount());
    }
    @And("^I should see the message as (.*)$")
    public void verifyValidationMessage(String message)
    {
        String expectedMessage = login.validationMessageDisplayed();
        Assert.assertEquals(expectedMessage, message);
    }
}
