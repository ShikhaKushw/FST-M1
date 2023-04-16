package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    //Declare global variable
    WebDriver driver;
    @BeforeClass
    public void setup(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
        //Setup Firfox driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize Webdriver Object
        driver= new FirefoxDriver();

        //open the browser
        driver.get("http://alchemy.hguy.co/orangehrm");

    }
    @Test
    public void login() {
        //Find and enter username and password
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        //Find and Click on Login button
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test(dependsOnMethods = "login")
    public void verifyHomepage() {
        //Verify that the homepage has opened.
        Boolean test;
        if (driver.findElement(By.id("welcome")).isDisplayed()) {
            test = true;
            System.out.println("Navigated to Homepage");
        } else {
            test = false;
            System.out.println("Not on Homepage");
        }

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
