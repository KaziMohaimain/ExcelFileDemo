package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;
import utilities.Driver;

public class BaseTest
{
    @BeforeSuite
    public void openBrowser()
    {
        System.out.println("<<<<<<openBrowser>>>>>>");
        Driver.getInstance().init();
    }

    @AfterSuite
    public void closeBrowser()
    {
        System.out.println("<<<<<<closeBrowser>>>>>>");
        Driver.getInstance().finalise();
    }
}
