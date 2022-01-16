package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver instance;

    public static Driver getInstance()
    {
        if(instance == null)
        {
            instance = new Driver();
            instance.init();
        }

        return instance;
    }

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void init()
    {
        System.setProperty("webdriver.chrome.driver", new ReadConfig().getChromePath());
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        driver=new ChromeDriver(capability);
        driver.manage().window().maximize();
        pleaseWait(15);
    }

    public void shiftToElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void shiftToElement(String selector, SelectBy type)
    {
        WebElement element = getElement(selector, type);
        shiftToElement(element);
    }

    public void shiftAndClick(String selector, SelectBy type)
    {
        WebElement element = getElement(selector, type);
        shiftToElement(element);
        element.click();
    }

    public void findAndClick(String selector, SelectBy type)
    {
        WebElement element = getElement(selector, type);
        element.click();
    }

    public void findAndFill(String selector, SelectBy type, String data)
    {
        WebElement element = getElement(selector, type);
        element.sendKeys(data);
    }

    public List<WebElement> getElements(String selector, SelectBy type)
    {
        By by = getQueryBy(selector, type);
        return driver.findElements(by);
    }
    public List<WebElement> getElements(String selector, SelectBy type, WebElement parent)
    {
        By by = getQueryBy(selector, type);
        return parent.findElements(by);
    }

    public WebElement getElement(String selector, SelectBy type)
    {
        By by = getQueryBy(selector, type);
        return driver.findElement(by);
    }

    public void switchToFrame(int index)
    {
        driver.switchTo().frame(index);
    }

    public void switchToRootFrame()
    {
        driver.switchTo().defaultContent();
    }

    public void quit()
    {
        driver.quit();
    }

    public void pleaseWait(long duration)
    {
        driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
    }

    public By getQueryBy(String key, SelectBy type)
    {
        By by = null;
        switch(type) {
            case XPATH:
                by = By.xpath(key);
                break;
            case ID:
                by = By.id(key);
                break;
            case NAME:
                by = By.name(key);
                break;
            case CSS:
                by = By.cssSelector(key);
                break;
            case TAG_NAME:
                by = By.tagName(key);
                break;
        }

        return by;
    }
}
