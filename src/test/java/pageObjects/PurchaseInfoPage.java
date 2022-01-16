package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.KeyType;

import java.util.List;

public class PurchaseInfoPage
{
    Driver driver = Driver.getInstance();

    public void addNewPurchase()
    {
        driver.pleaseWait(30);
        WebElement inputFieldsContainer = driver.getElement("/html/body/div[2]/div/div/div/form", KeyType.XPATH);
        List<WebElement> fields = driver.getElements("input", KeyType.TAG_NAME, inputFieldsContainer);
        int i = 1;
        for (WebElement field : fields) {
            field.sendKeys("field " + i);
        }

    }
}
