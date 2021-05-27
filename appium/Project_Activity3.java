//Activity:3
//Goal: Use the Google Keep app to add a note with a reminder
//Open the Google Keep app.
//Click the Create New Note button to add a new Note.
//Add a title for the note and add a small description.
//Click the reminder icon on the toolbar to add a reminder for Afternoon of the same day.
//Press the back button and switch to the Reminders page.
//Make an assertion to ensure that the note was added with a reminder


package Project;

import java.net.MalformedURLException;
import java.net.URL;
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

public class Project_Activity3 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("appPackage", "com.google.android.keep");
	    desiredCapabilities.setCapability("appActivity", ".activities.BrowseActivity");
	    desiredCapabilities.setCapability("noReset ", true);
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
	    wait = new WebDriverWait(driver, 20);
	    Thread.sleep(3000);
	    
	  }
@Test
public void addNotesWithReminder() throws InterruptedException {
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
	   driver.findElementByAccessibilityId("New text note").click();
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
	   driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Title-Activity3 -Google Keep Notes");
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/edit_note_text")));
	   driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Hello, This is a message from Nimesh");
	   Thread.sleep(3000);
	   driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Reminder\"]").click();
	   Thread.sleep(3000);
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/time_spinner")));
	   driver.findElementById("com.google.android.keep:id/time_spinner").click();
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[1][@text='Night']")));
	   driver.findElementByXPath("//android.widget.TextView[1][@text='Night']").click();
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/save")));
	   driver.findElementById("com.google.android.keep:id/save").click();
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));
	   driver.findElementByAccessibilityId("Open navigation drawer").click();
	   Thread.sleep(5000);
	   driver.findElementByAccessibilityId("Open navigation drawer").click();
	   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.LinearLayout[2]/android.widget.TextView[@text='Reminders']")));
	   driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.TextView[@text='Reminders']").click();
	   Thread.sleep(3000);
	   wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.LinearLayout/android.widget.TextView[1]")));
	   String result=driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView[1]").getText();
	   Thread.sleep(3000);
	   System.out.println(result);
	   Assert.assertEquals("Title-Activity3 -Google Keep Notes",result);
      
	   }
	   
  @AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
