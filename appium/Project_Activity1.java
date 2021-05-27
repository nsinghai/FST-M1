//Activity:1
//Goal: Use the Google Tasks app to create a list of activities that need to be completed.
//Open the Google Tasks app.
//Click the button to add a new task.
//Add the following tasks:
//	 - Complete Activity with Google Tasks
// - Complete Activity with Google Keep
// - Complete the second Activity Google Keep
//After each task is added, the Save button should be clicked.
//Write an assertion to ensure all three tasks have been added to the list.

package Project;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Project_Activity1 {
	AppiumDriver<MobileElement> driver = null;
	
	  @BeforeTest
	  public void beforeTest() throws MalformedURLException {
	      // Set the Desired Capabilities
	 	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
		    desiredCapabilities.setCapability("platformName", "android");
		    desiredCapabilities.setCapability("automationName", "UiAutomator2");
		    desiredCapabilities.setCapability("appPackage", "com.google.android.apps.tasks");
		    desiredCapabilities.setCapability("appActivity", ".ui.TaskListsActivity");
		    desiredCapabilities.setCapability("noReset", true);

	       // Instantiate Appium Driver
	       URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	       driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
	  }
	
	@Test
  public void actualTest() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		String[] tasksToAdd = {
				"Complete Activity with Google Tasks",
				"Complete Activity with Google Keep",
				"Complete the second Activity Google Keep"
								};
		
		for(String taskToAdd : tasksToAdd) {
			//wait for app to load
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
			//Find add task button
			driver.findElementById("tasks_fab").click();
			//wait for next input
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
			//Add Task
			driver.findElementById("add_task_title").sendKeys(taskToAdd);
			driver.findElementById("add_task_done").click();
		}
		
		//Assertions
		wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"), 3));
		List<MobileElement> tasksAdded = driver.findElementsById("task_name");
		assertEquals(tasksAdded.size(),3);
		assertEquals(tasksAdded.get(2).getText(), "Complete Activity with Google Tasks");
  }


  @AfterTest
  public void afterTest() {
      driver.quit();
  }
}
