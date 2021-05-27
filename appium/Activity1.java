//Activity:1
//
//
//Using the Appium inspector and Eclipse, write a TestNG program to perform a multiplication operation between two numbers.
//Start by initializing the the Appium DesiredCapabilities() with the deviceId, deviceName, paltformName, appPackage, and appActivity values as follows:
//    deviceId: "<Your device ID>"
//    deviceName: "<Your device name>"
//    platformName: "android"
//    appPackage: "com.android.calculator2"
//    appActivity: "com.android.calculator2.Calculator"
//Create the driver object for the AndroidDriver() and initialize it with the Appium server URL/IP address and the desired capabilities.
//Run the program.


package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;
	
  @Test
  public void Multiply_test() throws MalformedURLException {
      // Set the Desired Capabilities
 	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("automationName", "UiAutomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", ".Calculator");
	    desiredCapabilities.setCapability("noReset", true);

       // Instantiate Appium Driver
       URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
       driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
       
       MobileElement digit_5 = driver.findElementById("digit_5");
       digit_5.click();
       
       MobileElement multiply = driver.findElementByAccessibilityId("multiply");
       multiply.click();
       
       digit_5.click();
       
       MobileElement equals = driver.findElementByAccessibilityId("equals");
       equals.click();
       
       System.out.println("Calculator is closed now");
                  
      //Assertion
      String result = driver.findElementById("result").getText();
      Assert.assertEquals(result,"25");
	  
  }
	  @AfterTest
	  public void afterTest() {
	      driver.quit();
  }
}
