//Activity:10_1
//Create a Class and a main() method
//Create a WebDriver instance, named driver, with the FirefoxDriver().
//Open a browser with https://www.training-support.net/selenium/input-events
//Get the title of the page using driver.getTitle() and print out the title.
//On the page, perform
//Left click and print the value of the side in the front.
//Double click to show a random side and print the number.
//Right click and print the value shown on the front of the cube.
//Finally, close the browser.

package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);

        //Open browser
        driver.get("https://www.training-support.net/selenium/input-events");
        
        //page Title
        System.out.println("Page Title: " + driver.getTitle());
        
        //Find the cube
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));

        //Left click
        actions.click(cube);
        WebElement cubeVal = driver.findElement(By.className("active"));
        System.out.println("Left Click: " + cubeVal.getText());
        
        //Double click
        actions.doubleClick(cube).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Double Click: " + cubeVal.getText());
        
        //Right click        
        actions.contextClick(cube).perform();
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Right Click: " + cubeVal.getText());

        //Close browser
        driver.close();
    }
}
