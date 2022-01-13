package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReadConfig;

public class LoginPage
{
    WebDriver driver = Driver.getInstance().getDriver();

    public void login(String userName, String password)
    {
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("btnLogin")).click();
    }
}
