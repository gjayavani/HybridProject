package cucumberNew.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css = "#home-page-tabs")
    WebElement homepagetabs;
    @FindBy(css = ".login")
    WebElement signinlink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isUserOnHomePage()
    {
        return homepagetabs.isDisplayed();
    }

    public void goToAuthenticationPage()
    {
        signinlink.click();
    }
}


