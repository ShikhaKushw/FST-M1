package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity9 {
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
    public void printEmergencyNumber() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'Emergency Contacts')]")).click();
        WebElement table = driver.findElement(By.id("emgcontact_list"));
        List<WebElement> allrows = table.findElements(By.tagName("tr"));
        System.out.println(allrows.size());
        List<WebElement> allcolumns = driver.findElements(By.xpath("//table[@id='emgcontact_list']/thead/tr/th"));
        System.out.println(allcolumns.size());

        // To display table data
        for (WebElement row : allrows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Print the contents of each cell
            for (WebElement cell : cells) {

                System.out.print(cell.getText());
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
