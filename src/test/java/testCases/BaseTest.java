package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.Driver;
import utilities.ReadConfig;

import java.util.concurrent.TimeUnit;

public class BaseTest
{

    @BeforeSuite
    public void openBrowser()
    {
        Driver.getInstance().loadApplicationURL();
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
