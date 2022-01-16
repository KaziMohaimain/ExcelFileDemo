package pageObjects;

import utilities.Driver;
import utilities.SelectBy;

public class PurchaseInfoPage
{
    Driver driver = Driver.getInstance();

    public void addNewPurchase()
    {
        driver.switchToFrame(0);

        driver.findAndClick("btnNew", SelectBy.ID);
        driver.findAndFill("supplier_info", SelectBy.ID, "Kazi Habib");
        // To do

        driver.switchToRootFrame();
    }
}
