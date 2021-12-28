package testCases.authentication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class SignUpTest
{
    @Test
    public void register()
    {
        System.out.println("<<<<<<register>>>>>>");
        WebDriver driver = Driver.getInstance().getDriver();
    }
}