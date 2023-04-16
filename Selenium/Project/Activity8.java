package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
    //Declare global variable
    WebDriver driver;
    WebDriverWait wait;

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
    public void applyLeave() {
        driver.findElement(By.id("menu_dashboard_index")).click();
        driver.findElement(By.xpath("(//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/orangehrmLeavePlugin/images/ApplyLeave.png'])[2]")).click();
        Select dropdown = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        dropdown.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-04-28");
        driver.findElement(By.id("applyBtn")).click();

    }

    @Test(priority = 3)
    public void statusOfLeaveApplied() {
        WebElement Leave = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        Actions a = new Actions(driver);
        a.moveToElement(Leave).build().perform();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();

        WebElement Status = driver.findElement(By.xpath("//a[contains(text(),'Pending Approval(7.00)')]"));
        String text1 = Status.getText();
        Assert.assertEquals(text1,"Pending Approval(7.00)");

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //CLose the broswer
        driver.close();
    }
}