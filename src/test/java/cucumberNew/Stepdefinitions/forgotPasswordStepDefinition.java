package cucumberNew.Stepdefinitions;

import cucumberNew.Pages.ForgotPasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class forgotPasswordStepDefinition
{
     ForgotPasswordPage forgotpwd = new ForgotPasswordPage();
    @When("^I click on Forgot password link in login panel$")
    public void selectForgotPasswordLink() throws InterruptedException
    {
       forgotpwd.forgotPassword();
        Thread.sleep(5000);
    }
    @Then("^I should be navigated to password recovery page$")
    public void userIsOnPasswordRecoveryPage()
    {
        Assert.assertTrue(forgotpwd.passwordRecoveryPage());
    }
    @When("^I enter an email (.*) to retrieve forgot password$")
    public void enterEmailToGetForgotPassword(String forgotemail)throws InterruptedException
    {
        forgotpwd.enterEmailToRecoverPassword(forgotemail);
        Thread.sleep(5000);
    }
    @And("^I click on Retrieve Password button$")
    public void selectRetrievePwdButton()
    {
        forgotpwd.retrievePasswordTab();
    }
    @Then("^I should see the confirmation message (.*)$")
    public void userCanSeeTheConfirmationMessage(String message)
    {
        String displayedtext = forgotpwd.verifyAlertMessage();
        Assert.assertTrue(displayedtext.contains(message));
    }
}
