//Activity:3
//In @Test methods, perform the following operations:
//    Calculate 5 + 9 and print the result to the console.
//    Calculate 10 - 5 and print the result to the console.
//    Calculate 5 * 100 and print the result to the console.
//    Calculate 50 / 2 and print the result to the console.
//    Write assertions for all the results.

package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
	AppiumDriver<MobileElement> driver = null;
  @BeforeTest
  public void BeforeTest() throws MalformedURLException {
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
  }
  
  @Test
	
  public void add() {
	
      driver.findElementById("digit_5").click();
      driver.findElementById("op_add").click();
      driver.findElementById("digit_9").click();
	
      // Perform Calculation
      driver.findElementById("eq").click();
	
      // Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "14");
  }
	
  @Test
  public void subtract() {
	
      driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
	  driver.findElementById("op_sub").click();
	  driver.findElementById("digit_5").click();
	
      // Perform Calculation
	  driver.findElementById("eq").click();
	
      // Display Result
	  String result = driver.findElementById("result").getText();
	  System.out.println(result);
	
      Assert.assertEquals(result, "5");
  }
	
  @Test
	  public void multiply() {
      driver.findElementById("digit_5").click();
      driver.findElementById("op_mul").click();	
      driver.findElementById("digit_1").click();
	  driver.findElementById("digit_0").click();
      driver.findElementById("digit_0").click();
	
      // Perform Calculation
      driver.findElementById("eq").click();
	
      // Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "500");
  }
	
  @Test
  public void divide() {
      driver.findElementById("digit_5").click();
      driver.findElementById("digit_0").click();
      driver.findElementById("op_div").click();
      driver.findElementById("digit_2").click();

      // Perform Calculation
      driver.findElementById("eq").click();
	
      // Display Result
      String result = driver.findElementById("result").getText();
      System.out.println(result);
      Assert.assertEquals(result, "25");
	
  }
  
  @AfterTest
  public void afterTest() {
      driver.quit();
  }
}
