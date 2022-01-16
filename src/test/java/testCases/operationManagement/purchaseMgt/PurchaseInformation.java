package testCases.operationManagement.purchaseMgt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class PurchaseInformation
{
    WebDriver driver = Driver.getInstance().getDriver();

    public void operationPanelDropdown()
    {
        WebElement operationPanel = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(operationPanel).perform();
    }

    public void purchaseMgtPanel()
    {
        WebElement purchaseMgt = driver.findElement(By.);
        Actions action = new Actions(driver);
        action.moveToElement(purchaseMgt).perform();
        purchaseMgt.click();
    }

    @Test
    public void purchaseInfo()
    {
        operationPanelDropdown();
        purchaseMgtPanel();

        WebElement purchaseInfo = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[2]/ul/li[1]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(purchaseInfo).perform();
        purchaseInfo.click();
    }
}
