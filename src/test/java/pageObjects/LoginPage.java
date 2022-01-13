package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReadConfig;

public class LoginPage
{
    WebElement loginOption;

    public static void goToLoginPage(String baseURL)
    {
        LoginPage loginPage = new LoginPage();

        WebDriver driver = Driver.getInstance().getDriver();
        driver.get(baseURL);
    }
}
