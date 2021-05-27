//Activity:5 - SMS Application
//In this activity, we will be using the default SMS application to send a message to yourself.
//    Create a new TestNG class and add the needed annotations.
//    In the setup annotation, add the AndroidDriver object and initialize with the hub URL and the desired capabilities.
//Write a script to perform the following actions:
//    Open the SMS application
//    Click the "Create New Message" button to write a new SMS.
//    Locate the contact fields and enter your own phone number to send a message to your own phone number.
//    Locate the message input field and enter the message "Hello from Appium".
//    Locate the send button and click it.
//    Write an assertion to verify that the message has been sent successfully.

package Activities;

import java.net.MalformedURLException;
import java.net.URL;
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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel_4_emulator");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("appPackage", "com.google.android.apps.messaging");
        desiredCapabilities.setCapability("appActivity", ".ui.ConversationListActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, desiredCapabilities);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void smsTest() {
    	   // Locate the button to write a new message and click it
            driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/start_new_conversation_button")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.messaging:id/recipient_text_view")));
        driver.findElementById("recipient_text_view").sendKeys("9980698804");
        
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        
               
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        // Focus on the message text box
        String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
        
        driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("Hello from Appium");
 
        // Send the message
        driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();
 
        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text")));
 
        // Assertion
        String sentMessageText = driver.findElementById("com.google.android.apps.messaging:id/message_text").getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
