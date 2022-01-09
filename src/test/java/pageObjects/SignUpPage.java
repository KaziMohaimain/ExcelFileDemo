package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class SignUpPage {

    List<WebElement> inputFields;

    //Constructor
    public SignUpPage()
    {
        inputFields = Driver.getInstance().getDriver().findElements(By.cssSelector("form input"));
        System.out.println(inputFields.size());
    }

    public void inputData(List<String> datas)
    {
        for(int i=0;i<inputFields.size();i++)
        {
            inputFields.get(i).sendKeys(datas.get(i));
        }
    }
}
