//Activity:2
//Goal: Use the Google Keep app to add a note.
//Open the Google Keep app.
//Click the Create New Note button to add a new Note.
//Add a title for the note and add a small description.
//Press the back button and make an assertion to ensure that the note was added.

package Project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Project_Activity2 {
	AppiumDriver<MobileElement> driver = null;
	
  @Test
  public void googleKeepTest() {
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  driver.findElementById("new_note_button").click();
	  driver.findElementById("editable_title").sendKeys("My Title");
	  driver.findElementById("edit_note_text").sendKeys("This is a sample text from Nimesh");
	  driver.findElementByAccessibilityId("Open navigation drawer").click(); 
	  
	   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/index_note_title")));
	   String noteTitle=driver.findElementById("com.google.android.keep:id/index_note_title").getText();
	   String noteDescription=driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
	   Assert.assertEquals("Title-Activity2 -Google Keep Notes",noteTitle);
	   Assert.assertEquals("Hello..Reminder note to complete Appium project",noteDescription);
  }
    
  @BeforeTest
  	  public void beforeTest() throws MalformedURLException {
	      // Set the Desired Capabilities
	 	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
		    desiredCapabilities.setCapability("platformName", "android");
		    desiredCapabilities.setCapability("automationName", "UiAutomator2");
		    desiredCapabilities.setCapability("appPackage", "com.google.android.keep");
		    desiredCapabilities.setCapability("appActivity", "com.google.android.apps.keep.ui.activities.BrowseActivity");
		    desiredCapabilities.setCapability("noReset", true);

	       // Instantiate Appium Driver
	       URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	       driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
  }

  @AfterTest
  public void afterTest() {
	    driver.quit();
  }

}
