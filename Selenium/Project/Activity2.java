package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
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
    public void verifyHeaderImage() {
        WebElement image = driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png']"));
        System.out.println("URL of image:" + image.getAttribute("src"));
    }
        //Get url of header image
    @AfterClass
    public void tearDown() {
        driver.close();
    }



}
