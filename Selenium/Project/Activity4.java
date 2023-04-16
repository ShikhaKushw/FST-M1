package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity4 {
    //Declare global variable
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "Null");
        //Setup Firfox driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize Webdriver Object
        driver = new FirefoxDriver();

        //open the browser
        driver.get("http://alchemy.hguy.co/orangehrm");

    }

    @Test(priority = 1)
    public void login() {
        //Find and enter username and password
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        //Find and Click on Login button
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test(priority = 2)
    public void findPIM() {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();

    }

    @Test(priority = 3)
    public void addEmployee() {
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Abraham");
        driver.findElement(By.id("btnSave")).click();
    }

    @Test(priority = 4)
    public void verifyAddedEmployee() {
        driver.findElement(By.xpath("//a[contains(.,'Employee List')]")).click();
        WebElement employeeNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
        employeeNameField.sendKeys("John");
        employeeNameField.sendKeys(Keys.TAB);
        driver.findElement(By.id("searchBtn")).click();
        WebElement tableContent = driver.findElement(By.xpath("//tr[@class='odd'][1]"));
        String text1 = tableContent.getText();
        Assert.assertEquals(text1,"1166 NewUser Employee2");

    }


    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
