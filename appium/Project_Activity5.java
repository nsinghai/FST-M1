//Activity:5
//Goal: Opening a page on the browser and testing a simple login page with correct and incorrect credentials
//Open the Chrome app on your device.
//Go to the following URL: https://www.training-support.net/selenium
//Scroll to find the Login Form card and click it.
//Once the page loads, find the username and password input fields on the page and enter the following credentials in it:
//Username: admin
//Password: password
//Click on the Log in button to submit.
//If the credentials are correct, the following message should appear:
//If the credentials are incorrect, the following message appears:
//Write a test case for each scenario - One with the correct credentials and one with incorrect credentials
//Finally, write assertions for both test cases to verify results.

package Project;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity5 {
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
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
        wait = new WebDriverWait(driver,20);
        
}
@BeforeMethod
public void openLogInURL() {
        driver.get("https://www.training-support.net/selenium");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		driver.findElementByXPath("//android.view.View[contains(@text,'Login')]").click();
           }
 @Test(priority=1)
 public void chromeLoginSuccessful() throws InterruptedException {
    	              
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
        driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("admin");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("password");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
        String msg=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
        System.out.println(msg);
        Assert.assertEquals("Welcome Back, admin", msg);
                      		       
    }
    
    @Test(priority=2)
    public void chromeLoginInvalidCredentials() throws InterruptedException {
    	              
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
        driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("jodha");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("akbar123");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
        String msg=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
        System.out.println(msg);
        Assert.assertEquals("Invalid Credentials", msg);
                      		       
    }
 
    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}
