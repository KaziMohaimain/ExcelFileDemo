package pageObjects;

import utilities.Driver;
import utilities.SelectBy;
import utilities.ReadConfig;

public class LoginPage {


    ReadConfig readConfig = new ReadConfig();

    public void login()
    {
        Driver driver = Driver.getInstance();
        driver.findAndFill("username", SelectBy.NAME, readConfig.getUsername());
        driver.findAndClick("loginBtn", SelectBy.NAME);

        driver.findAndFill("password", SelectBy.NAME, readConfig.getPassword());
        driver.findAndClick("loginBtn", SelectBy.NAME);
    }
}
