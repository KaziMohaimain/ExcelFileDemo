package testCases.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utilities.Driver;

public class SignInTest
{
    @Test
    public void login()
    {
        System.out.println("<<<<<<login>>>>>>");
        Driver.getInstance().getDriver().get("http://localhost/savolution.net/sadmin/");
        LoginPage loginPage = new LoginPage();
        loginPage.login("User.786", "your pass");
    }

    public void logout()
    {
        System.out.println("<<<<<<logOut>>>>>>");
        WebDriver driver = Driver.getInstance().getDriver();
    }
}