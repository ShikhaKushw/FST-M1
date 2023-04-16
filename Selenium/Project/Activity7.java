package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
    //Declare global variable
    WebDriver driver;
    WebDriverWait wait;
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
    @Test(priority = 1)
    public void login() {
        //Find and enter username and password
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        //Find and Click on Login button
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test(priority = 2)
    public void findMyInfoMenu() {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

    }
    @Test(priority = 3)
    public void addQualification() {
        driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewQualifications/empNumber/1'][contains(.,'Qualifications')]")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
        driver.findElement(By.id("experience_from_date")).clear();
        driver.findElement(By.id("experience_from_date")).sendKeys("2012-02-16");
        driver.findElement(By.id("experience_to_date")).clear();
        driver.findElement(By.id("experience_to_date")).sendKeys("2018-02-16");
        driver.findElement(By.id("btnWorkExpSave")).click();
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
