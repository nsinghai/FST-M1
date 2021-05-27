//Activity:4
//Goal: Opening a page on the browser and testing a to-do list page
//Open the Chrome app on your device.
//Go to the following URL: https://www.training-support.net/selenium
//Scroll to find the To-Do List card and click it.
//Once the page loads, find the input field on the page and enter the following three tasks:
//Add tasks to list
//Get number of tasks
//Clear the list
//Click on each of the tasks added to strike them out.
//Finally, clear the list.
//Add assertions to verify that the test has passed or failed.

package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity4 {
	AndroidDriver<MobileElement> driver;
	 WebDriverWait wait;
	
@BeforeClass
	public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.chrome");
        desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        desiredCapabilities.setCapability("noReset", true);
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
        wait = new WebDriverWait(driver,10);
        driver.get("https://www.training-support.net/selenium");
           }
 
 @Test
 public void chromeTodoList() throws InterruptedException {
    	
	 	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));        
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
        Thread.sleep(3000);
        String[] tasks= {"i)Add tasks to list","ii)Get number of tasks","iii)Clear the list"};
        
        for (String task : tasks) 
        {
        	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[4]/android.view.View[1]/android.widget.EditText")));
        	driver.findElementByXPath("//android.view.View[4]/android.view.View[1]/android.widget.EditText").sendKeys(task);
        	
        	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
         }
        Thread.sleep(3000);
        String addedtask1=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View").getText();
        String addedtask2=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View").getText();
        String addedtask3=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View").getText();
        Assert.assertEquals("i)Add tasks to list", addedtask1);
        Assert.assertEquals("ii)Get number of tasks", addedtask2);
        Assert.assertEquals("iii)Clear the list", addedtask3);
        List<MobileElement> addedTasks = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
        System.out.println("no. of tasks: " + addedTasks.size());
        Assert.assertEquals(addedTasks.size(), 4);
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]").click();
        Thread.sleep(3000);
        List<MobileElement> addedTasks1 = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
        System.out.println("no. of tasks: " + addedTasks1.size());
        Assert.assertEquals(addedTasks1.size(), 0);
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
