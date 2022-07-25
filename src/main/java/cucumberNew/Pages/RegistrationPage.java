package cucumberNew.Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage extends BasePage {
    @FindBy(css = "#email_create")
    WebElement email;
    @FindBy(css = "#SubmitCreate")
    WebElement submit;
    @FindBy(css = ".page-heading")
    WebElement createaccounttab;
    @FindBy(css = "#id_gender1") WebElement gender1;
    @FindBy(css =  "#id_gender2") WebElement gender2;
    @FindBy(css = "#customer_firstname") WebElement fname;
    @FindBy(css = "#customer_lastname") WebElement lname;
    @FindBy(css = "#passwd") WebElement password;
    @FindBy(css = "#days") WebElement day;
    @FindBy(css = "#months") WebElement month;
    @FindBy(css = "#years") WebElement year;
    @FindBy(css = "#address1") WebElement address;
    @FindBy(css = "#id_state") WebElement state;
    @FindBy(css = "#city") WebElement city;
    @FindBy(css = "#postcode") WebElement postcode;
    @FindBy(css = "#phone_mobile") WebElement mobile;
    @FindBy(css = "#submitAccount") WebElement submitaccount;
    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li") WebElement message;
    public RegistrationPage()
    {
        PageFactory.initElements(driver,this);
    }

    public boolean userOnAuthentication() {
        return createaccounttab.isDisplayed();
    }

    public void enterEmailToCreate(String emailId) {
        email.sendKeys(emailId);
    }

    public void selectCreateAccountTab() {
        submit.click();
    }

    public void enterDetails(String title,String firstname,String lastname,String pwd) throws InterruptedException
    {
        if (title.equalsIgnoreCase("Mr")) {
            gender1.click();
        } else if (title.equalsIgnoreCase("Mrs")) {
            gender2.click();
        }
        Thread.sleep(10000);
        fname.sendKeys(firstname);
        lname.sendKeys(lastname);
        password.sendKeys(pwd);
    }
    public void enterDOB(String days,String months,String years)
    {
        Select selectday = new Select(day);
        selectday.selectByValue(days);
        Select selectmonth = new Select(month);
        selectmonth.selectByValue(months);
        Select selectyear = new Select(year);
        selectyear.selectByValue(years);
    }
    public void enterAddress(String address1,String city1,String state1,String zip1,String mobile1) {
        address.sendKeys(address1);
        city.sendKeys(city1);
        Select selectstate = new Select(state);
        selectstate.selectByVisibleText(state1);
        postcode.sendKeys(zip1);
       // Select selectcountry = new Select(driver.findElement(By.cssSelector()));
       // selectcountry.selectByVisibleText(country);
        mobile.sendKeys(mobile1);
    }
    public void submitTab()
    {
       submitaccount.click();
    }
    public String verifyMessage()
    {
        return message.getText();
    }
    public void provideRegistrationDetails(DataTable table) throws InterruptedException
    {
        List<String> data = table.asList();
        String address1 = data.get(0);
        Thread.sleep(5000);
        address.sendKeys(address1);
        city.sendKeys(data.get(1));
        Select selectstate = new Select(state);
        selectstate.selectByVisibleText(data.get(2));
        postcode.sendKeys(data.get(3));
        mobile.sendKeys(data.get(4));
    }
}