package pageObjects.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReadConfig;

import java.util.List;

public class HomePage {

    WebDriver driver = Driver.getInstance().getDriver();

    public void initialize() {


        driver.get(new ReadConfig().getApplicationURL());


        List<WebElement> options = driver.findElements(By.cssSelector("#navbarSupportedContent #navbarDropdown"));

    }


}
