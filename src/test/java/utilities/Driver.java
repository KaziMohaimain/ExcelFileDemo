package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void quit()
    {
        driver.quit();
    }
}
