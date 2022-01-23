package pageObjects;

import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.SelectBy;
import utilities.XMLReader;

import java.util.List;

public class PurchaseInfoPage
{
    Driver driver = Driver.getInstance();

    public void addNewPurchase()
    {
        List<String> selectors = List.of(
                "supplier_info",
                "product_name",
                "lot_or_batch",
                "product_quantity",
                "product_price",
                "Remarks"
        );

        List<String> datas = XMLReader.getRow("purchaseInfoData.xlsx", 1);

        driver.switchToFrame(0);

        driver.findAndClick("btnNew", SelectBy.ID);
        //driver.findAndFill("supplier_info", SelectBy.ID, "Kazi Habib");
        // To do

        for(int i=0;i<selectors.size();i++)
        {
            driver.findAndFill(selectors.get(i), SelectBy.ID, datas.get(i));
        }

        Select invoiceTo = new Select(driver.getElement("InvoiceTo", SelectBy.ID));
        invoiceTo.selectByIndex(2);

        driver.switchToRootFrame();
    }
}