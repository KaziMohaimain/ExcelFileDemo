package testCases.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utilities.Driver;
import utilities.ReadConfig;

public class InitialAuthenticationTest {

    ReadConfig readConfig = new ReadConfig();

    @BeforeTest
    public void login()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @AfterTest
    public void logout()
    {

    }
}
