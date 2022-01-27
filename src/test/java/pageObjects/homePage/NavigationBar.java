package pageObjects.homePage;

import utilities.Driver;
import utilities.SelectBy;

public class NavigationBar {

    Driver driver = Driver.getInstance();

    public void openPurchaseReturn()
    {

    }

    public void openPurchasePayment()
    {

    }

//Common for all:
    public void operationPanelDropdown()
    {
        driver.shiftToElement("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/a", SelectBy.XPATH);
    }

//Specific for purchase tab:
    public void purchaseMgtPanel()
    {
        //driver.shiftToElement("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[2]/ul/li[1]/a", KeyType.XPATH);
        driver.shiftToElement("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[2]/a", SelectBy.XPATH);
    }

    public void openPurchaseInfo()
    {
        operationPanelDropdown();
        purchaseMgtPanel();
        driver.shiftAndClick("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[2]/ul/li[1]/a", SelectBy.XPATH);
    }

//Specific for Sales tab:
    public void salesMgtPanel()
    {
        driver.shiftToElement("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[4]/a", SelectBy.XPATH);
    }


    public void openSalesInfo()
    {
        operationPanelDropdown();
        salesMgtPanel();
        driver.shiftAndClick("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[2]/ul/li[4]/ul/li[1]/a", SelectBy.XPATH);
    }

}
