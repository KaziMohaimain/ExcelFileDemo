package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderTest 
{
    @BeforeClass
    public void beforeOrderClass()
    {
        System.out.println("<<<<<<beforeOrderClass>>>>>>");
    }

    @Test(priority = 1)
    public void addOrder()
    {
        System.out.println("<<<<<<addOrder>>>>>>");
    }

    @Test(priority = 3)
    public void getOrder()
    {
        System.out.println("<<<<<<getOrder>>>>>>");
    }

    @Test(priority = 2)
    public void removeOrder()
    {
        System.out.println("<<<<<<removeOrder>>>>>>");
    }

    @AfterClass
    public void afterOrderClass()
    {
        System.out.println("<<<<<<afterOrderClass>>>>>>");
    }
    
}
