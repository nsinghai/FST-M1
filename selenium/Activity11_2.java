//Activity:11.2
// Create a Class and a main() method
//    For this activity import the following classes
//        org.openqa.selenium.support.ui.Alert
//    Create a WebDriver instance, named driver, with the FirefoxDriver().
//    Open a browser with https://www.training-support.net/selenium/javascript-alerts
//    Get the title of the page using driver.getTitle() and print out the title.
//    Use findElement() to find the button to open a CONFIRM alert and click it.
//    Switch the focus from the main window to the Alert box and get the text in it and print it.
//    Close the alert once with alert.accept() and again with alert.dismiss()
//    Finally, close() the browser.

package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        
        //Get the title of the page
        System.out.println("Page Title: " + driver.getTitle());

        //Click the button to open a simple alert
        driver.findElement(By.cssSelector("button#confirm")).click();

        //Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();

        //Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        System.out.println("Alert text is: " + alertText);
        
        Thread.sleep(1000);

        //Close the alert with OK
       // confirmAlert.accept();

        //Close the browser with Cancel
        confirmAlert.dismiss();

        //Close the Browser
        driver.close();
    }
}
