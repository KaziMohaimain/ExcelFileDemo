package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.Driver;
import utilities.ReadConfig;

import java.util.concurrent.TimeUnit;

public class BaseTest
{
    ReadConfig readconfig = new ReadConfig();
    WebDriver driver = Driver.getInstance().getDriver();

    @BeforeSuite
    public void openBrowser()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(readconfig.getApplicationURL());

        System.out.println("<<<<<<openBrowser>>>>>>");
        // Nothing to do for now
    }

    @AfterSuite
    public void closeBrowser()
    {
        System.out.println("<<<<<<closeBrowser>>>>>>");
        //Driver.getInstance().quit();
    }

}
