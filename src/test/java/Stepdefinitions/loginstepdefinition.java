package Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class loginstepdefinition
{
    String baseurl = "http://automationpractice.com/index.php";
    WebDriver driver;
    @Before
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseurl);
        driver.manage().window().maximize();
    }
    @After
    public void closeBrowser() throws InterruptedException
    {
       Thread.sleep(10000);
        driver.close();
    }
    @Given("^I am on the home page$")
    public void isUserOnHomePage()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector("#home-page-tabs")).isDisplayed());
    }
    @When("^I select sign in tab$")
    public void selectsigninTab() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".login")).click();
        Thread.sleep(10000);
    }

    @Then("^I should be on the Authentication page$")
    public void isUserOnAuthenticationpage()
    {
        Assert.assertTrue(driver.findElement(By.cssSelector("#authentication")).isDisplayed());
    }

    @When("^I enter email as (.*) & password as (.*)")
    public void enterValidCredentials(String username,String password) throws InterruptedException
    {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#email")).sendKeys(username);
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
    }
    @And("^I select sign in link$")
    public void selectLoginTab() throws InterruptedException
    {
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
    }

    @Then("^I should be logged in successfully$")
    public void isUserLoggedIn() throws InterruptedException
    {
        Thread.sleep(10000);
        Assert.assertTrue(driver.getTitle().contains("My account"));
    }

    @And("^I should be on My account page$")
    public void isUserOnMyAccountPage() throws InterruptedException
    {
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-account")).isDisplayed());
    }
    @And("^I should see the message as (.*)$")
    public void verifyValidationMessage(String message)
    {
        String expectedMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        Assert.assertEquals(expectedMessage, message);
    }
}