package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.ReadConfig;

public class LoginPage {


    ReadConfig readConfig = new ReadConfig();

    public void login()
    {
        WebDriver driver = Driver.getInstance().getDriver();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(readConfig.getUsername());
        driver.findElement(By.name("loginBtn")).click();

        driver.findElement(By.name("password")).sendKeys(readConfig.getPassword());
        driver.findElement(By.name("loginBtn")).click();
    }
}
