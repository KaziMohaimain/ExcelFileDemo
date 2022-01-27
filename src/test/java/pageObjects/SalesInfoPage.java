package pageObjects;

import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.SelectBy;
import utilities.XMLReader;

import java.util.List;

public class SalesInfoPage
{
    Driver driver = Driver.getInstance();

    public void addNewSales()
    {
        List<String> selectors = List.of(
                "customer_name",
                "product_name",
                "product_quantity",
                "product_price",
                "Remarks"
        );

        List<List<String>> records = XMLReader.getRows("sales.xlsx");

        driver.switchToFrame(0);

        driver.findAndClick("btnNew", SelectBy.ID);

        for(List<String> record : records)
        {
            for(int i=0;i<selectors.size();i++)
            {
                driver.findAndFill(selectors.get(i), SelectBy.ID, record.get(i+1));
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.switchToRootFrame();
    }
}
