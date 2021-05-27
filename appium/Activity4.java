//Activity:4 - Contacts App
//Add a new contact to the list of contacts:
//    Find and click the button to add a new contact.
//    Find and fill the first name, last name, and phone number fields with the data provided.
//    Click on Save.
//    Write an assertion to ensure the new contact has been added.


package Activities;

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

public class Activity4 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	 @BeforeTest
	  public void BeforeTest() throws MalformedURLException {
		     // Set the Desired Capabilities
		 	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			    desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
			    desiredCapabilities.setCapability("platformName", "android");
			    desiredCapabilities.setCapability("automationName", "UiAutomator2");
			    desiredCapabilities.setCapability("appPackage", "com.android.contacts");
			    desiredCapabilities.setCapability("appActivity", ".activities.PeopleActivity");
			    desiredCapabilities.setCapability("noReset", true);

		       // Instantiate Appium Driver
		       URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		       driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
		       wait = new WebDriverWait(driver, 5);
	  }
	
  @Test
  public void addContact() {
      // Click on add new contact floating button
      driver.findElementByAccessibilityId("Create new contact").click();
      
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar")));
	
      // Find the first name, last name, and phone number fields
      driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
      wait = new WebDriverWait(driver, 5);
      driver.findElementByXPath("//android.widget.EditText[@text='Surname']").sendKeys("Varma");
      wait = new WebDriverWait(driver, 5);
      driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("9991284782");
	
	
      // Save the contact
      driver.findElementById("editor_menu_save_button").click();
      
      System.out.println("Contact has been added successfully");
      
      wait = new WebDriverWait(driver, 5);
	
      // Wait for contact card to appear
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.android.contacts:id/toolbar")));

      // Assertion
      MobileElement mobileCard = driver.findElementById("toolbar_parent");
      Assert.assertTrue(mobileCard.isDisplayed());
	
      String contactName = driver.findElementById("large_title").getText();
      Assert.assertEquals(contactName, "Aaditya Varma");
  }


  @AfterTest
  public void afterTest() {
      driver.quit();
  }

}
