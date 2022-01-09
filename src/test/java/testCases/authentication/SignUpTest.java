package testCases.authentication;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import utilities.Driver;
import utilities.XMLReader;

import java.util.List;

public class SignUpTest
{
    @Test
    public void register()
    {
        HomePage homepage = new HomePage();

        homepage.initialize();
        homepage.goToSignUpPage();

        SignUpPage signUpPage = new SignUpPage();
        List<String> data = XMLReader.getRow("signUpData.xlsx", 1);
        signUpPage.inputData(data);
    }
}