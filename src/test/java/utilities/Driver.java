package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Driver {

    ReadConfig readconfig=new ReadConfig();
    public String baseURL=readconfig.getApplicationURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();


    private static Driver instance;

    public static Driver getInstance()
    {
        if(instance == null)
        {
            instance = new Driver();
        }

        return instance;
    }

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void init()
    {
        System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void finalise()
    {
        //driver.quit();
    }
}
