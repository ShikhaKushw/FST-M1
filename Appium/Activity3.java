package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static examples.ActionsBase.doSwipe;

public class Activity3 {

    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options().
                setPlatformName("Android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.android.chrome").
                        setAppActivity("com.google.android.apps.chrome.Main").
                noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        // Open Selenium page
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View"))).click();

        // Scroll to end by setting start and end points
        Point start = new Point((int)(dims.width*0.5), (int)(dims.height*0.9));
        Point end = new Point((int)(dims.width*0.5), (int)(dims.height*0.6));
        doSwipe(driver, start, end, 100);

        //Locate element and click it
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]"))).click();

        // Wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
        //Find element on the page
        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        // Enter Task
        addTaskInput.sendKeys("Add tasks to list");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Get number of tasks");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskInput.sendKeys("Clear the list");
        addTaskButton.click();
        Thread.sleep(1000);

        //Strike the added items in list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();
        Thread.sleep(500);

        // Clear the list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Clear List')]")).click();

//        //Assertion
        List<WebElement> taskAdded = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']"));
        Assert.assertEquals(taskAdded.size(), 0);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
