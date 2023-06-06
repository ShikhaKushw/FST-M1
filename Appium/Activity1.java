package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
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
import java.util.concurrent.TimeUnit;

public class Activity1 {

    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options().
                setPlatformName("Android").
                setAutomationName("UiAutomator2").
                setAppPackage("com.google.android.apps.tasks").
                        setAppActivity(".ui.TaskListsActivity").
                noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void addFirstTask() {

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        WebElement task = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task.click();
        task.sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    @Test(priority = 2)
    public void addSecondTask() {

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        WebElement task = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task.click();
        task.sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
    @Test(priority = 3)
    public void addThirdTask() {

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        WebElement task = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task.click();
        task.sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }
  @Test(priority = 4)
  public void assertion() {
      List<WebElement> taskAdded = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name')]"));
      Assert.assertEquals(taskAdded.size(), 3);
  }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
