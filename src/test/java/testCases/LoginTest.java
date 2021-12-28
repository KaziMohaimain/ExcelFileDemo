package testCases;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

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
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div[1]/div[4]/div[2]"));
        element.click();

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section[1]/div/div[3]"));
        element2.click();



        List<WebElement> elements = driver.findElements(By.cssSelector("form input"));


        for(WebElement e : elements)
        {
            e.sendKeys("ABC");
        }

       // List<String> fieldXPaths = List.of("//*[@id=\"name\"]","//*[@id=\"email\"]","//*[@id=\"password\"]","//*[@id=\"cPassword\"]");
    }

    @AfterMethod
    public void afterLogin()
    {
        System.out.println("<<<<<<afterLogin>>>>>>");
    }
}
