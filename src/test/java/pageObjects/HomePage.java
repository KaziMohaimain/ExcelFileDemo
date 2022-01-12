package pageObjects;

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

    WebElement accountOption;
//    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[3]")
//    @FindBy(css = ".dropdown .dropdown-menu .dropdown-item")
//    @CacheLookup
    WebElement loginOption;
//    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[4]")
//    @CacheLookup
    WebElement signUpOption;

    public void initialize() {

    //For home:
        //driver.get("https://infallible-swartz-b50174.netlify.app/");
    //For office:
        driver.get(new ReadConfig().getApplicationURL());


        List<WebElement> options = driver.findElements(By.cssSelector("#navbarSupportedContent #navbarDropdown"));
        accountOption = options.get(1);
        //PageFactory.initElements(Driver.getInstance().getDriver(), this);

        loginOption = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[3]"));
        signUpOption = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[4]"));
    }

    public void goToSignUpPage() {
        if(accountOption == null || signUpOption == null)
        {
            System.out.println("Options not initialized");
            return;
        }
        accountOption.click();
        signUpOption.click();
    }

    public void goToLoginPage() {
        if(accountOption == null || loginOption == null)
        {
            System.out.println("Options not initialized");
            return;
        }
        accountOption.click();
        loginOption.click();
    }

}
