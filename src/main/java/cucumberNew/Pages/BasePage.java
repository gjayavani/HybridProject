package cucumberNew.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasePage
{
    public static WebDriver driver;
    public static String browsername ;
    public static String baseurl = "http://automationpractice.com/index.php";

    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseurl);
        driver.manage().window().maximize();
    }
    public void closeBrowser()
    {
        driver.close();
    }


}
