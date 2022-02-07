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

        List<List<String>> datas = XMLReader.getRows("purchaseInfoData.xlsx");

        driver.switchToFrame(0);

        driver.findAndClick("btnNew", SelectBy.ID);

        for(List<String> row : datas)
        {
            for(int i=0;i<selectors.size() && i < 2;i++)
            {
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<"+selectors.get(i)+"============"+row.get(i)+">>>>>>>>>>>>>>>>>>>>>>>>>");
                driver.findAndFill(selectors.get(i), SelectBy.ID, row.get(i));
            }

            Select invoiceTo = new Select(driver.getElement("InvoiceTo", SelectBy.ID));
            invoiceTo.selectByIndex(2);

            //driver.findAndClick("btnAdd", SelectBy.ID);
            break;
        }

        //driver.findAndClick("btnSave", SelectBy.ID);

        driver.switchToRootFrame();
    }
}