package testCases.authentication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.Driver;

public class SignUpTest
{
    @Test
    public void register()
    {
        HomePage homepage = new HomePage();

        homepage.initialize();
        homepage.goToSignUpPage();


    }
}