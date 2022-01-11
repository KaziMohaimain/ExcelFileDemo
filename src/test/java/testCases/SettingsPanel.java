package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReadConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class SettingsPanel
{
    ReadConfig readconfig=new ReadConfig();

    public String baseURL=readconfig.getApplicationURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();

    WebDriver driver;

    public SettingsPanel()
    {
        driver = Driver.getInstance().getDriver();

        if(driver == null)
        {
            System.out.println("==========================Driver null============================");
        }
    }

    public void settingsPanelDropdown()
    {
        WebElement settingPanel = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(settingPanel).perform();
    }

    public void backToPrevious()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().back();
    }

    //Inside the Panel Methods:
    public void globalInformation() throws IOException {
        WebElement globalInfoTab = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[1]/a"));
        moveAndClick(globalInfoTab);

        //Fill up the fields:
        //driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[1]/a")).sendKeys(XLUtils.getCellData("src/test/java/com/inetbanking/testData/FieldEntryData.xlsx","Sheet1",2,2));
    }

    public void agentVerification()
    {
        WebElement agentVerificationTab = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[2]/a"));
        moveAndClick(agentVerificationTab);
    }

    public void charge()
    {
        WebElement chargeTab = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[4]/a"));
        moveAndClick(chargeTab);

        WebElement chargeInfo = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[4]/ul/li[1]/a"));
        moveAndClick(chargeInfo);

        backToPrevious();

        WebElement chargeAdd = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[4]/ul/li[2]/a"));
        moveAndClick(chargeAdd);
    }

    public void userAdministration()
    {
        WebElement userAdminTab = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[6]/a"));
        moveAndClick(userAdminTab);

        WebElement createUser = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[6]/ul/li[1]/a"));
        moveAndClick(createUser);

        backToPrevious();

        WebElement userPermission = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[6]/ul/li[2]/a"));
        moveAndClick(userPermission);
    }

    public void othersTab()
    {
        WebElement othersTab = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[8]/a"));
        moveAndClick(othersTab);

        WebElement projectEntry = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[8]/ul/li[1]/a"));
        moveAndClick(projectEntry);

        WebElement langRes = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[8]/ul/li[2]/a"));
        moveAndClick(langRes);
    }

    public void locationTab()
    {
        WebElement locationTab = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[10]/a"));
        moveAndClick(locationTab);

        WebElement countryInfo = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[10]/ul/li[1]/a"));
        moveAndClick(countryInfo);

        WebElement provinceInfo = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[10]/ul/li[2]/a"));
        moveAndClick(provinceInfo);

        WebElement villageInfo = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li[1]/ul/li[10]/ul/li[3]/a"));
        moveAndClick(villageInfo);
    }

    //Execute Settings Panel Tests Method:
    @Test
    public void executeSPtests() throws IOException {
        login();

        settingsPanelDropdown();
        //Global Information tab:
        globalInformation();
        backToPrevious();
        //Agent Verification tab:
        agentVerification();
        backToPrevious();
        //Charge Tab:
        charge();
        backToPrevious();
        //User/Administration Tab:
        userAdministration();
        backToPrevious();
        //Others Tab:
        othersTab();
        backToPrevious();
        //Location Tab:
        locationTab();
    }

    private void login()
    {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("btnLogin")).click();

        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
    }

    public void moveAndClick(WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        element.click();
    }
}
