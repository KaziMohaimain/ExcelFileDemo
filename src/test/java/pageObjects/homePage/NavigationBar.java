package pageObjects.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import utilities.KeyType;

import java.util.concurrent.TimeUnit;

public class NavigationBar {

    Driver driver = Driver.getInstance();

    public void openPurchaseReturn()
    {

    }

    public void openPurchasePayment()
    {

    }

    public void operationPanelDropdown()
    {
        driver.shiftToElement("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/a",KeyType.XPATH);
    }


    public void purchaseMgtPanel()
    {
        //driver.shiftToElement("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[2]/ul/li[1]/a", KeyType.XPATH);
        driver.shiftToElement("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[2]/a", KeyType.XPATH);
    }

    public void openPurchaseInfo()
    {
        operationPanelDropdown();
        purchaseMgtPanel();
        driver.shiftAndClick("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[2]/ul/li[1]/a", KeyType.XPATH);
    }


}
