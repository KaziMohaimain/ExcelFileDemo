package testCases.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReadConfig;

public class InitialAuthenticationTest {

    ReadConfig readConfig = new ReadConfig();

    @BeforeTest
    public void login()
    {
        WebDriver driver = Driver.getInstance().getDriver();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(readConfig.getUsername());
        driver.findElement(By.name("loginBtn")).click();

        driver.findElement(By.name("password")).sendKeys(readConfig.getPassword());
        driver.findElement(By.name("loginBtn")).click();
    }

    @AfterTest
    public void logout()
    {

    }
}
