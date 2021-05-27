//Activity:2
//In this activity we will be practicing with a page in a browser on the mobile device.
//    Create a new TestNG class and add the needed annotations.
//    In the setup annotation, add the AndroidDriver object and initialize with the hub URL and the desired capabilities.
//In @Test method,
//    Open the following URL: https://www.training-support.net/
//    Locate the title on the page and print it to console.
//    Locate the About Us button and click it.
//    Print the title of the new page.

package Activities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity2 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	  @BeforeTest
	  public void beforeTest() throws MalformedURLException {
	      // Set the Desired Capabilities
	 	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
		    desiredCapabilities.setCapability("platformName", "android");
		    desiredCapabilities.setCapability("automationName", "UiAutomator2");
		    desiredCapabilities.setCapability("appPackage", "com.android.chrome");
		    desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		    desiredCapabilities.setCapability("noReset", true);

	       // Instantiate Appium Driver
	       URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	       driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
	       wait = new WebDriverWait(driver,10);
	  }	
	
  @Test
  public void chrome_test() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
//    Open the following URL: https://www.training-support.net/
	  driver.get("https://www.training-support.net/");
	  	  
//    Locate the title on the page and print it to console.
	  String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	  System.out.println("Page Title: " + pageTitle);
	  
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  
//    Locate the About Us button and click it.      
	  MobileElement aboutButton = driver.findElementById("about-link");  	
      aboutButton.click();
	
      String newPageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
	
      System.out.println("Title on new page: " + newPageTitle);
		
      // Assertions	
      Assert.assertEquals(pageTitle, "Training Support");
	
      Assert.assertEquals(newPageTitle, "About Us");
	
  }


  @AfterTest
  public void afterTest() {
      driver.quit();
  }

}
