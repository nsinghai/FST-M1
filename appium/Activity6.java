//Activity:6 - Google Chrome Images
//Write a Appium test script to perform the following:
//    Open Google Chrome on your mobile device/emulator and open the following URL: https://www.training-support.net/selenium/lazy-loading
//    Get the number of images shown in the view
//    Scroll to the card with Helen's post
//    Get number of images shown on the screen after scrolling.

package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
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
        wait = new WebDriverWait(driver, 5);

        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void imageScrollTest() {
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // wait for page to load
        MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));

        // Count the number of images shown on the screen
        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        
        // Assertion before scrolling
        Assert.assertEquals(numberOfImages.size(), 4);
        
        // Scroll to Helen's post
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Find the number of images shown after scrolling
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        
        // Assertion after scrolling
        Assert.assertEquals(numberOfImages.size(), 4);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}