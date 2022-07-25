package cucumberNew.Stepdefinitions;

import cucumberNew.Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageStepDefinition
{
    HomePage homepage = new HomePage();

    @Given("^I am on the home page$")
    public void userIsOnHomePage()
    {
      Assert.assertTrue(homepage.isUserOnHomePage());
    }
    @When("^I select sign in tab$")
    public void selectSigninTab() throws InterruptedException
    {
        Thread.sleep(5000);
        homepage.goToAuthenticationPage();
        Thread.sleep(10000);
     }
}