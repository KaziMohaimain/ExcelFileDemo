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

    /**
     * Create a webDriver and initialize its properties and options.
     */
    private void init()
    {
        System.setProperty("webdriver.chrome.driver", new ReadConfig().getChromePath());
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        driver=new ChromeDriver(capability);
        driver.manage().window().maximize();
    }

    /**
     * Read the application URL from the config and load it on browser.
     */
    public void loadApplicationURL()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(new ReadConfig().getApplicationURL());
    }

    //Move the Mouse over the Web element:
    public void shiftToElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    //Get the element by the Selector and move mouse over it:
    public void shiftToElement(String selector, SelectBy type)
    {
        WebElement element = getElement(selector, type);
        shiftToElement(element);
    }

    //Get the element by the Selector, move mouse over it, and click:
    public void shiftAndClick(String selector, SelectBy type)
    {
        WebElement element = getElement(selector, type);
        shiftToElement(element);
        element.click();
    }

    /**
     * Get element by the Selector, and click:
     * @param selector The selector string i.e. value of xpath, id, class, css selector, name
     * @param type     The type of the selector string i.e. xpath, id, class, css selector, name
     */
    public void findAndClick(String selector, SelectBy type)
    {
        WebElement element = getElement(selector, type);
        element.click();
    }

    /**
     * Get the input field element by the Selector, and fill data:
     * @param selector The selector string i.e. value of xpath, id, class, css selector, name
     * @param type     The type of the selector string i.e. xpath, id, class, css selector, name
     * @param data     The string data to fill in that input field
     */
    public void findAndFill(String selector, SelectBy type, String data)
    {
        WebElement element = getElement(selector, type);
        element.sendKeys(data);
    }

    /**
     * Find all the webElements as list from the given selector:
     * @param selector The selector string i.e. value of xpath, id, class, css selector, name
     * @param type     The type of the selector string i.e. xpath, id, class, css selector, name
     * @return         A List of WebElements matching the selector
     */
    public List<WebElement> getElements(String selector, SelectBy type)
    {
        By by = getQueryBy(selector, type);
        return driver.findElements(by);
    }

    /**
     * Find all the webElements as list from the given selector, but the elements are children of the parent.
     * @param selector The selector string i.e. value of xpath, id, class, css selector, name
     * @param type     The type of the selector string i.e. xpath, id, class, css selector, name
     * @param parent   The element inside which we are searching for a match.
     * @return         A list of WebElements matching the selector inside the Parent Element.
     */
    public List<WebElement> getElements(String selector, SelectBy type, WebElement parent)
    {
        By by = getQueryBy(selector, type);
        return parent.findElements(by);
    }

    /**
     * Find a single webElement from the given selector
     * @param selector The selector string i.e. value of xpath, id, class, css selector, name
     * @param type     The type of the selector string i.e. xpath, id, class, css selector, name
     * @return         The matching element.
     */
    public WebElement getElement(String selector, SelectBy type)
    {
        By by = getQueryBy(selector, type);
        return driver.findElement(by);
    }

    /**
     * Switch to the iFrame specified by the index
     * @param index The index of the iFrame.
     */
    public void switchToFrame(int index)
    {
        driver.switchTo().frame(index);
    }

    /**
     * Switch to root Frame which is the Parent of the current frame.
     */
    public void switchToRootFrame()
    {
        driver.switchTo().defaultContent();
    }

    /**
     * Quit the WebDriver.
     */
    public void quit()
    {
        driver.quit();
    }

    /**
     * Wait for a specific time.
     * @param duration  The amount of time to wait in Seconds.
     */
    public void pleaseWait(long duration)
    {
        driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
    }

    /**
     * Create a selenium BY object from the selector and type
     * @param selector The selector string i.e. value of xpath, id, class, css selector, name
     * @param type     The type of the selector string i.e. xpath, id, class, css selector, name
     * @return         A BY object that can be used to find web element.
     */
    private By getQueryBy(String selector, SelectBy type)
    {
        By by = null;
        switch(type) {
            case XPATH:
                by = By.xpath(selector);
                break;
            case ID:
                by = By.id(selector);
                break;
            case NAME:
                by = By.name(selector);
                break;
            case CSS:
                by = By.cssSelector(selector);
                break;
            case TAG_NAME:
                by = By.tagName(selector);
                break;
        }

        return by;
    }
}
