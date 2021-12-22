package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Driver;

public class BaseTest
{
    @BeforeTest
    public void openBrowser()
    {
        System.out.println("<<<<<<openBrowser>>>>>>");
        Driver.getInstance().init();
    }

    @AfterTest
    public void closeBrowser()
    {
        System.out.println("<<<<<<closeBrowser>>>>>>");
        Driver.getInstance().finalise();
    }

}
