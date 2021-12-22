package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class LoginTest
{
    @BeforeMethod
    public void beforeLogin()
    {
        System.out.println("<<<<<<beforeLogin>>>>>>");
    }
    @Test
    public void login()
    {
        System.out.println("<<<<<<login>>>>>>");
         WebDriver driver = Driver.getInstance().getDriver();
    }

    @AfterMethod
    public void afterLogin()
    {
        System.out.println("<<<<<<afterLogin>>>>>>");
    }
}
