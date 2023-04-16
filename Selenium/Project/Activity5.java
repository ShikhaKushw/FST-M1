package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity5 {
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
        public void editInfo() {
            driver.findElement(By.id("btnSave")).click();
            driver.findElement(By.id("personal_txtEmpFirstName")).clear();
            driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Harmoine");
            driver.findElement(By.id("personal_txtEmpLastName")).clear();
            driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Granger");
            driver.findElement(By.id("personal_optGender_1")).click();
            Select dropDown = new Select(driver.findElement(By.id("personal_cmbNation")));
            dropDown.selectByVisibleText("American");
            driver.findElement(By.id("personal_txtEmpLastName")).clear();
            driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("1998-03-02");
            driver.findElement(By.id("btnSave")).click();

        }
        @AfterClass
        public void tearDown() {
            driver.close();
        }

}
