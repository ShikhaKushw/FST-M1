package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
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
    public void validateDirectoryMenu() {
        Boolean visible= driver.findElement(By.xpath("//b[contains(.,'Directory')]")).isDisplayed();
        if(visible == true) {
            System.out.println("Directory is Visible");
        } else
        {
            System.out.println("Directory is not visible");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Directory = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
        Directory.click();
        Directory.click();
    }
    @Test(priority = 3)
    public void verifyHeadingTest() {
        String infoBox = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(infoBox, "Search Directory");


    }
    @AfterClass
    public void tearDown(){
        //CLose the broswer
        driver.close();
    }
}
