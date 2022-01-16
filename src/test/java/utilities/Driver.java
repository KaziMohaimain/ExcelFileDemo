package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        pleaseWait(15);
    }

    public void shiftToElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void shiftToElement(String key, KeyType keyType)
    {
        WebElement element = getElement(key, keyType);
        shiftToElement(element);
    }

    public void shiftAndClick(String key, KeyType keyType)
    {
        WebElement element = getElement(key, keyType);
        shiftToElement(element);
        element.click();
    }


    public List<WebElement> getElements(String key, KeyType keyType)
    {
        By by = getQueryBy(key, keyType);
        return driver.findElements(by);
    }
    public List<WebElement> getElements(String key, KeyType keyType, WebElement parent)
    {
        By by = getQueryBy(key, keyType);
        return parent.findElements(by);
    }

    public WebElement getElement(String key, KeyType keyType)
    {
        By by = getQueryBy(key, keyType);
        return driver.findElement(by);
    }


    public void quit()
    {
        driver.quit();
    }

    public void pleaseWait(long duration)
    {
        driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
    }

    public By getQueryBy(String key, KeyType keyType)
    {
        By by = null;
        switch(keyType) {
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
