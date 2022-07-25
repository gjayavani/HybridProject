package cucumberNew.Stepdefinitions;

import cucumberNew.Pages.BasePage;
import io.cucumber.java.After;
import org.junit.Before;

public class Hooks extends BasePage
{
    @Before
    public void startBrowser()
    {
        openBrowser();
    }
    @After
    public void exitBrowser() throws InterruptedException
    {
        Thread.sleep(10000);
        closeBrowser();
    }
}
