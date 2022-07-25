package cucumberNew.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage
{

    @FindBy(css = "#authentication") WebElement loginpage;
    @FindBy(css = "#SubmitLogin") WebElement logintab;
    @FindBy(css = "#email") WebElement loginemail;
    @FindBy(css = "#passwd") WebElement loginpwd;
    @FindBy(css = "My account - My Store") WebElement loggedin;
    @FindBy(css = "#my-account") WebElement myaccount;
    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li") WebElement validationmessage;
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }
    public boolean userOnAuthentication()
    {
        return loginpage.isDisplayed();
    }
    public void selectSigninTab()
    {
        logintab.click();
    }
    public void enterEmailPwdToLogin(String emaillogin,String password)
    {
        loginemail.sendKeys(emaillogin);
        loginpwd.sendKeys(password);
    }
    public boolean userOnMyAccount()
    {
        return myaccount.isDisplayed();
    }
    public String validationMessageDisplayed()
    {
        return validationmessage.getText();
    }
    public String userLoggedIn()
    {
        return loggedin.getText();
    }
}
