//Activity:10_3
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://training-support.net/selenium/drag-drop
//Get the title of the page using driver.getTitle() and print out the title.
//Find the ball and simulate a click and drag to move it into "Dropzone 1".
//Verify that the ball has entered Dropzone 1.
//Once verified, move the ball into "Dropzone 2".
//Verify that the ball has entered Dropzone 2.
//Once verified, close the browser.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {
    public static void main(String[] args) throws InterruptedException {
    
    	// Declare new WebDriver
        WebDriver driver = new FirefoxDriver();
        
        // Declare new WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        // Navigate to the activity page
        driver.get("https://training-support.net/selenium/drag-drop");
        
        //Get the title of the page
        System.out.println("Page Title: " + driver.getTitle());
        
        // Wait for the ball to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));
        
        // Save the different elements in variables
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement drop1 = driver.findElement(By.id("droppable"));
        WebElement drop2 = driver.findElement(By.id("dropzone2"));
        
        // Compile a custom action for Drag/Drop and perform it.
        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDrop(ball, drop1).build().perform();
        
        // Wait for the Dropzone's color to change 
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop1, "background-color"));
        System.out.println("ENTERED DROPZONE 1");
        
        // Repeat for the second dropzone
        dragAndDrop.dragAndDrop(ball, drop2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop2, "background-color"));
        System.out.println("ENTERED DROPZONE 2");
        
        // Close the browser
        driver.close();
    }
}
