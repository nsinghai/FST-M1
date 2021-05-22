//Activity:10_2
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://www.training-support.net/selenium/input-events
//Get the title of the page using driver.getTitle() and print out the title.
//Perform the following actions,
//Press the key of your first name in caps
//Press CTRL+a and the CTRL+c to copy all the text on the page.
//(Paste the text in a text editor to verify results.)
//Finally, close the browser.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
        String pressedKeyText;

        //Open browser
        driver.get("https://www.training-support.net/selenium/input-events");
        
        //page Title
        System.out.println("Page Title: " + driver.getTitle());
        
        WebElement pressedKey = driver.findElement(By.id("keyPressed"));
        
        //Create action sequence for initials
        Action actionSequence1 = actions.sendKeys("N").build();
        actionSequence1.perform();
        pressedKeyText = pressedKey.getText();
        System.out.println("Pressed key is: " + pressedKeyText);        
        
        //Create action sequence for Spacebar
        Action actionSequence2 = actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build();
        actionSequence2.perform();
        pressedKeyText = pressedKey.getText();
        System.out.println("Pressed key is: " + pressedKeyText);

        //Close browser
        driver.close();
    }
}
